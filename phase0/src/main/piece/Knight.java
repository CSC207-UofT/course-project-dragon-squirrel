package piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import Board.BoardInterface;
import static java.lang.Math.abs;


public class Knight extends Piece{

    public Knight(String name, Color color){
        super(name, color);
    }

	@Override
	public int getValue() {
		return KNIGHT_VALUE;
	}

	/**
	 * Check: move is an L-shape
	 * @return true if move is valid according to knight behaviour, false otherwise.
	 */
	@Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        int X = abs(oldX - newX);
        int Y = abs(oldY - newY);
        return (X == 2 && Y == 1) || (X == 1 && Y == 2);
    }

	/**
	 * @return a List<Point> of the valid coordinates the knight can move to given piece behaviour, game rules, and
	 * present board state.
	 */
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y){
    	List<Point> moves = new ArrayList<>();
		
		// Knight moves in L-shaped

	    // Given a 5*5 box, find all spots that has Manhattan distance of 3
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				if ((abs(i) + abs(j) == 3) && isValidToMove(x + i, y + j, b))
					moves.add(new Point(x + i,y + j));
			}
		}
	
		return moves;
    }

	@Override
	public Piece deepCopy() {
		Knight newPiece = new Knight(name, color);
		newPiece.status = this.status;
		return newPiece;
	}
}
