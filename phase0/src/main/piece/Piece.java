package piece;

import java.util.List;

import java.awt.Point;
import Board.BoardInterface;


public abstract class Piece implements PieceInterface {
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
     * @return true if x and y are within the board boundaries, false otherwise.
     */
    public boolean withinBoundary(int x, int y, BoardInterface b) {
    	return x < b.getBoundaries().x && y < b.getBoundaries().y;    	
    }

    /**
     * @return true if this piece and the piece at board[x][y] are opponents (not the same colour), false otherwise.
     */
    public boolean isOpponentPiece(int x, int y, BoardInterface b) {
    	return (!hasSameColor(b.getPiece(x, y)));
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
     * @return a List<Point> of the valid coordinates the piece at board[x][y] can move to given piece behaviour,
     * game rules, and present board state.
     */
	public abstract List<Point> getValidMoves(BoardInterface b, int x, int y);

    public abstract Piece deepCopy();
}
