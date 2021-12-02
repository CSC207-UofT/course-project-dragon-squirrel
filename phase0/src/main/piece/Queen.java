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

	/**
	 * Check: move is a straight horizontal / vertical / diagonal line
	 * @return true if move is valid according to queen behaviour, false otherwise.
	 */
	@Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        return Math.abs(oldX - newX) == Math.abs(oldY - newY) || (Math.abs(oldX - newX) == 0 || Math.abs(oldY - newY) == 0);
    }

	/**
	 * @return a List<Point> of the valid coordinates the queen can move to given piece behaviour, game rules, and
	 * present board state.
	 */
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
