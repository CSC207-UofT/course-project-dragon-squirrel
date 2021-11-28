package piece;

import java.util.ArrayList;

import java.util.List;
import java.awt.*;
import Board.Board;
import Board.BoardInterface;


public class Bishop extends Piece{

    public Bishop(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == Math.abs(oldCoorY - newCoorY);
    }
        
    public boolean canReplace(BoardInterface b, int x, int y) {			//it will check if a piece is already placed on that position and can bishop destroy it
    	return isOpponentPiece(x, y, b);
    }
    
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) 
    {
		List<Point> moves = new ArrayList<Point>();

		//Bishop can move in diagonals
		boolean SW = true;
		boolean NW = true;
		boolean NE = true;
		boolean SE = true;
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if(withinBoundary(x+i, y+i, b) && SW) {				
				if(b.isPositionVacant(x+i, y+i) == false) {
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

}
