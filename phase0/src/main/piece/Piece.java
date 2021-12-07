package piece;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.awt.Point;
import Board.BoardInterface;


public abstract class Piece implements PieceInterface, Serializable {
    protected String name;  // ex: "w_pawn_1"
    protected Color color;    // Black or White (BLACK/WHITE)
    protected boolean status;     // This tells whether this piece has been moved during the turn

    public Piece(String name, Color color) {
        this.name = name;
        this.color = color;
        this.status = false;
    }

    /**
     * @return piece name (ex. "w_king", "b_queen")
     */
    public String getName() { return name; }

    /**
     * @return BLACK or WHITE depending on piece colour.
     */
    public Color getColor() { return color; }

    public abstract int getValue();

    /**
     * @return true if the piece has been moved during the turn, false otherwise.
     */
    public boolean getStatus() { return status; }

    /**
     * @return true if this piece is black, false if it is white.
     */
    public boolean isBlack() { return color == Color.BLACK; }

    /**
     * @return true if this piece is white, false if it is black.
     */
    public boolean isWhite() { return color == Color.WHITE; }

    /**
     * Set status.
     */
    public void setStatus(boolean status){
        this.status = status;
    }

    /**
     * @return true if move is valid given piece specific behaviours, false otherwise.
     */
    public abstract boolean validMove(int oldX, int oldY, int newX, int newY);

    /**
     * @return true if this piece is of the same color as the targetPiece, false otherwise
     */
    public boolean hasSameColor(PieceInterface targetPiece) {
        return this.color == targetPiece.getColor();
    }

    /**
     * @return a List<Point> of the valid coordinates the piece can move to given piece behaviour, game rules, and
     * present board state.
     */
	public abstract List<Point> getValidMoves(BoardInterface b, int x, int y);

    public abstract Piece deepCopy();


    // Helper methods for subclasses
    protected boolean isOpponentPiece(int x, int y, BoardInterface b) {
        return (!hasSameColor(b.getPiece(x, y)));
    }

    protected boolean withinBoundary(int x, int y, BoardInterface b) {
        return x >= 0 && y >= 0 && x < b.getBoundaries().x && y < b.getBoundaries().y;
    }

    protected boolean isValidToMove(int x, int y, BoardInterface b) {
        return withinBoundary(x, y, b) && (b.isPositionVacant(x, y) || isOpponentPiece(x, y, b));
    }

    /**
     * Exclusive for Bishop and Queen
     * Search the tiles diagonally and return all positions that can move to
     * @param b The board
     * @param x starting position x
     * @param y starting position x
     * @return  All the diagonal tiles that can move to in one step
     */
    protected List<Point> searchDiagonally(BoardInterface b, int x, int y) {
        List<Point> moves = new ArrayList<>();

        // i and j are direction indicator, can either be 1 or -1
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i == 0 || j == 0)
                    continue;

                // go to that direction step by step and look for available moves
                moves.addAll(searchDirection(b, x, y, i, j));
            }
        }
        return moves;
    }

    /**
     * Exclusive for Rook and Queen
     * Search the tiles on up, down, left, right and return all positions that can move to
     * @param b The board
     * @param x starting position x
     * @param y starting position x
     * @return  All the tiles that can move to in one step
     */
    protected List<Point> searchHorizontalAndVertically(BoardInterface b, int x, int y) {
        List<Point> moves = new ArrayList<>();

        // i and j are direction indicator, can either be 1 or -1
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i != 0 && j != 0)
                    continue;
                if (i == 0 && j == 0)
                    continue;

                // go to that direction step by step and look for available moves
                moves.addAll(searchDirection(b, x, y, i, j));
            }
        }

        return moves;
    }

    /**
     * Helper method, search all the tiles on the given direction and find ones that can be moved to
     * @param b The board
     * @param x starting position x
     * @param y starting position x
     * @param directionX    direction indicator for x, is either 1 or -1
     * @param directionY    direction indicator for y, is either 1 or -1
     * @return  All the tiles that can move to on the given direction
     */
    private List<Point> searchDirection(BoardInterface b, int x, int y, int directionX, int directionY) {
        List<Point> moves = new ArrayList<>();

        for (int dist = 1; true; dist++) {
            int targetX = x + dist * directionX;
            int targetY = y + dist * directionY;

            if (!withinBoundary(targetX, targetY, b))   // out of boundary, cannot go further
                break;

            if (b.isPositionVacant(targetX, targetY))   // vacant, can keep going
                moves.add(new Point(targetX, targetY));
            else if (isOpponentPiece(targetX, targetY, b)) {    // opponent's piece, can capture it
                moves.add(new Point(targetX, targetY));
                break;
            } else if (!isOpponentPiece(targetX, targetY, b))   // same color piece, cannot go further
                break;
            else    // for debug only
                throw new IndexOutOfBoundsException("current position " + targetX + " " + targetY);
        }

        return moves;
    }
}
