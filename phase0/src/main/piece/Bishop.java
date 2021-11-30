package piece;

import java.util.ArrayList;

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

	/**
	 * Check: move is a straight diagonal line
	 * @return true if move is valid according to bishop behaviour, false otherwise.
	 */
	@Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        return Math.abs(oldX - newX) == Math.abs(oldY - newY);
    }
        
    public boolean canReplace(BoardInterface b, int x, int y) {			//it will check if a piece is already placed on that position and can bishop destroy it
    	return isOpponentPiece(x, y, b);
    }

	/**
	 * @return a List<Point> of the valid coordinates the bishop can move to given piece behaviour, game rules, and
	 * present board state.
	 */
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) 
    {
		List<Point> moves = new ArrayList<>();

		//Bishop can move in diagonals
		boolean SW = true;
		boolean NW = true;
		boolean NE = true;
		boolean SE = true;
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if(withinBoundary(x+i, y+i, b) && SW) {				
				if(!b.isPositionVacant(x + i, y + i)) {
					if(canReplace(b, x+i, y+i))
						moves.add(new Point(x+i,y+i));	
					SW = false;
				}
				else
					moves.add(new Point(x+i,y+i));	
			}
			
			if(withinBoundary(x-i, y+i, b) && NW) {
				if(!b.isPositionVacant(x-i, y+i)) {
					if(canReplace(b, x-i, y+i))
						moves.add(new Point(x-i,y+i));	
					NW = false;
				}
				else
					moves.add(new Point(x-i,y+i));	
			}
			
			if(withinBoundary(x+i, y-i, b) && SE) {
				if(!b.isPositionVacant(x+i, y-i)) {
					if(canReplace(b, x+i, y-i))
						moves.add(new Point(x+i,y-i));	
					SE = false;
				}
				else
					moves.add(new Point(x+i,y-i));	
			}
			
			if(withinBoundary(x-i, y-i, b) && NE) {
				if(!b.isPositionVacant(x-i, y-i)) {
					if(canReplace(b, x-i, y-i))
						moves.add(new Point(x-i,y-i));	
					NE = false;					
				}
				else
					moves.add(new Point(x-i,y-i));	
			}
		}
		return moves;
	}

	@Override
	public Piece deepCopy() {
		Bishop newPiece = new Bishop(name, color);
		newPiece.status = this.status;
		return newPiece;
	}

}
