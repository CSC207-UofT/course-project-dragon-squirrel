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
		
		//Queen can move in any direction any number of spaces
		boolean right = true;
		boolean left = true;
		boolean up = true;
		boolean down = true;
		boolean NE = true;
		boolean SE = true;
		boolean SW = true;
		boolean NW = true;
		
		for(int i = 1; i < b.getBoundaries().x; i++) {

			if(withinBoundary(x, y+i, b) && right) {		//check in right direction
				if(!b.isPositionVacant(x, y + i)) {
					if(isOpponentPiece(x, y+i, b)) {
						moves.add(new Point(x,y+i));		
					}		
					right = false;
				}
				else {
					moves.add(new Point(x,y+i));	
				}

			}
			
			if(withinBoundary(x, y-i, b) && left) {				//check in left direction
				if(!b.isPositionVacant(x, y - i)) {
					if(isOpponentPiece(x, y-i, b)) {
						moves.add(new Point(x,y-i));		
					}
					left = false;
				}
				else {
					moves.add(new Point(x,y-i));	
				}

			}

			if(withinBoundary(x-i, y, b) && up) {				//check in up direction
				if(!b.isPositionVacant(x - i, y)) {
					if(isOpponentPiece(x-i, y, b)) {
						moves.add(new Point(x-i,y));		
					}
					up = false;
				}
				else {
					moves.add(new Point(x-i,y));	
				}

			}
			
			if(withinBoundary(x+i, y, b) && down) {					//check in down direction
				if(!b.isPositionVacant(x + i, y)) {
					if(isOpponentPiece(x+i, y, b)) {
						moves.add(new Point(x+i,y));		
					}
					down = false;
				}
				else {
					moves.add(new Point(x+i,y));	
				}

			}

			if(withinBoundary(x+i, y+i, b) && SW) {							//check in south-west diagonal
				if(!b.isPositionVacant(x + i, y + i)) {
					if(isOpponentPiece(x+i, y+i, b)) {
						moves.add(new Point(x+i,y+i));		
					}		
					SW = false;
				}
				else {
					moves.add(new Point(x+i,y+i));	
				}

			}

			if(withinBoundary(x-i, y+i, b) && NW) {					//check in north-west diagonal
				if(!b.isPositionVacant(x - i, y + i)) {
					if(isOpponentPiece(x-i, y+i, b)) {
						moves.add(new Point(x-i,y+i));		
					}
					NW = false;
				}
				else {
					moves.add(new Point(x-i,y+i));	
				}

			}

			if(withinBoundary(x+i, y-i, b) && SE) {					//check in south-east diagonal
				if(!b.isPositionVacant(x + i, y - i)) {
					if(isOpponentPiece(x+i, y-i, b)) {
						moves.add(new Point(x+i,y-i));		
					}
					SE = false;
				}
				else {
					moves.add(new Point(x+i,y-i));	
				}

			}

			if(withinBoundary(x-i, y-i, b) && NE) {				//check in north-east diagonal
				if(!b.isPositionVacant(x - i, y - i)) {
					if(isOpponentPiece(x-i, y-i, b)) {
						moves.add(new Point(x-i,y-i));		
					}		
					NE = false;
				}
				else {
					moves.add(new Point(x-i,y-i));	
				}

			}

		}

		return moves;
	}

	@Override
	public Piece deepCopy() {
		Queen newPiece = new Queen(name, color);
		newPiece.status = this.status;
		return newPiece;
	}

}
