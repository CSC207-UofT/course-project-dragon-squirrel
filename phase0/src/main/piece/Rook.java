package piece;
import java.util.ArrayList;

import java.util.List;
import java.awt.Point;
import Board.BoardInterface;
public class Rook extends Piece{

    public boolean hasMovedDuringGame;

    public Rook(String name, Color color){
        super(name, color);
    }

	@Override
	public int getValue() {
		return ROOK_VALUE;
	}

	@Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == 0 || Math.abs(oldCoorY - newCoorY) == 0;
    }
    
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		//Rooks move up and down the rank and file of the chessboard, and can move any number of spaces
	    return searchHorizontalAndVertically(b, x, y);
	}

	@Override
	public Piece deepCopy() {
		Rook newPiece = new Rook(name, color);
		newPiece.status = this.status;
		return newPiece;
	}

}
