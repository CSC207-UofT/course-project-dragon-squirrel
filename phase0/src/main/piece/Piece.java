package piece;

import java.util.List;

import java.awt.*;
import Board.Board;
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

    public boolean getStatus() { return status; }

    public boolean isBlack() { return color == Color.BLACK; }

    public boolean isWhite() { return color == Color.WHITE; }

    public void setStatus(boolean status){
        this.status = status;
    }
    
    public boolean withinBoundary(int x, int y, BoardInterface b) {
    	return x < b.getBoundaries().x && y < b.getBoundaries().y;    	
    }
    
    public boolean isOpponentPiece(int x, int y, BoardInterface b) {
    	return (!hasSameColor(b.getPiece(x, y)));
    }
    
    public abstract boolean validMove(int oldX, int oldY, int newX, int newY);
    
    public boolean hasSameColor(PieceInterface targetPiece) {
        return this.color == targetPiece.getColor();
    }

	public abstract List<Point> getValidMoves(BoardInterface b, int x, int y);
}
