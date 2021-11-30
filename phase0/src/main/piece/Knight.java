package piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import Board.BoardInterface;


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
        int X = Math.abs(oldX - newX);
        int Y = Math.abs(oldY - newY);
        return (X == 2 && Y == 1) || (X == 1 && Y == 2);
    }
    
    public boolean isEmptyOrValid(int x, int y, BoardInterface b) {
    	return (b.isPositionVacant(x,y) || (!b.isPositionVacant(x,y) && isOpponentPiece(x, y, b)));
    }

	/**
	 * @return a List<Point> of the valid coordinates the knight can move to given piece behaviour, game rules, and
	 * present board state.
	 */
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y){
    	List<Point> moves = new ArrayList<>();
		
		// Knight moves in L-shaped
		
    	for(int i=-2; i <= 2; i++) {
			if(i == 0)
				continue;
			int j = (x == 2 || x == -2) ? 1 : 2;
			if(withinBoundary(x+i, y+j, b) && isEmptyOrValid(x+i, y+j, b)) {
				moves.add(new Point(x+1,y+2));
			}

			if(withinBoundary(x+i, y-j, b) && isEmptyOrValid(x+1, y-j, b)) {
				moves.add(new Point(x+1, y-2));
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
