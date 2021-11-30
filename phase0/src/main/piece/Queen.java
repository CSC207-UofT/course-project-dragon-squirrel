package piece;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import Board.BoardInterface;

public class Queen extends Piece{

    public Queen(String name, Color color){
        super(name, color);
    }

	@Override
	public int getValue() {
		return QUEEN_VALUE;
	}

	@Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == Math.abs(oldCoorY - newCoorY) || (Math.abs(oldCoorX - newCoorX) == 0 || Math.abs(oldCoorY - newCoorY) == 0);
    }
    
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		List<Point> moves = new ArrayList<>();
		moves.addAll(searchDiagonally(b, x, y));
	    moves.addAll(searchHorizontalAndVertically(b, x, y));
		return moves;
	}

	@Override
	public Piece deepCopy() {
		Queen newPiece = new Queen(name, color);
		newPiece.status = this.status;
		return newPiece;
	}

}
