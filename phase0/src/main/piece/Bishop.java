package piece;

import java.util.List;
import java.awt.Point;
import Board.BoardInterface;


public class Bishop extends Piece{

    public Bishop(String name, Color color){
        super(name, color);
    }

	@Override
	public int getValue() {
		return BISHOP_VALUE;
	}

	@Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == Math.abs(oldCoorY - newCoorY);
    }

	/**
	 * @return a List<Point> of the valid coordinates the bishop can move to given piece behaviour, game rules, and
	 * present board state.
	 */
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) 
    {
	    return searchDiagonally(b, x, y);
	}

	@Override
	public Piece deepCopy() {
		Bishop newPiece = new Bishop(name, color);
		newPiece.status = this.status;
		return newPiece;
	}

}
