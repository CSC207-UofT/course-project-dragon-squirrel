package piece;

import java.util.List;
import java.awt.*;
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

    public String getName() { return name; }

    public Color getColor() { return color; }

    // This could be more handy than previous one
    public boolean isBlack() { return color == Color.BLACK; }

    public boolean isWhite() { return color == Color.WHITE; }

    public boolean getStatus() { return status; }

    public void setStatus(boolean status){
        this.status = status;
    }

    public abstract boolean validMove(int oldX, int oldY, int newX, int newY);

    public boolean hasSameColor(PieceInterface targetPiece) {
        return this.color == targetPiece.getColor();
    }

	public abstract List<Point> getValidMoves(BoardInterface b, int x, int y);

    // TODO implement it
    public Piece deepCopy() {
        return null;
    }

    /**
     * Return true if (x,y) is within boundary of Board b
     */
    protected boolean withinBoundary(int x, int y, BoardInterface b) {
        return x < b.getBoundaries().x && y < b.getBoundaries().y;
    }

    /**
     * Assume b[x][y] is a piece (not vacant)
     * Return true if b[x][y] has different color than this piece
     */
    protected boolean isOpponentPiece(int x, int y, BoardInterface b) {
        return b.getPiece(x, y).getColor() != this.color;
    }
}
