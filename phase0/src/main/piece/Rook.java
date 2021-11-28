package piece;
import java.util.ArrayList;

import java.util.List;
import java.awt.*;
import Board.Board;
import Board.BoardInterface;
public class Rook extends Piece{

    public boolean hasMovedDuringGame;

    public Rook(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == 0 || Math.abs(oldCoorY - newCoorY) == 0;
    }
    
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		List<Point> moves = new ArrayList<Point>();
		//Rooks move up and down the rank and file of the chessboard, and can move any number of spaces
		
		boolean right = true;
		boolean left = true;
		boolean up = true;
		boolean down = true;
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			
			if(withinBoundary(x, y+i, b) && right) {		//right
				if(b.isPositionVacant(x, y+i) == false) {
					if(isOpponentPiece(x, y+i, b))
						moves.add(new Point(x,y+i));						
					right = false;
				}
				else
					moves.add(new Point(x,y+i));	
			}
			
			if(withinBoundary(x, y-i, b) && left) {			//left
				if(b.isPositionVacant(x, y-i) == false) {
					if(isOpponentPiece(x, y-i, b))
						moves.add(new Point(x,y-i));	
					left = false;
				}
				else
					moves.add(new Point(x,y-i));	
			}
			
			if(withinBoundary(x+i, y, b) && down) {			//down
				if(b.isPositionVacant(x+i, y) == false) {
					if(isOpponentPiece(x+i, y, b))
						moves.add(new Point(x+i,y));	
					down = false;
				}
				else
					moves.add(new Point(x+i,y));	
			}
			
			if(withinBoundary(x-i, y, b) && up) {			//up
				if(b.isPositionVacant(x-i, y) == false) {
					if(isOpponentPiece(x-i, y, b))
						moves.add(new Point(x-i,y));	
					up = false;
				}
				else
					moves.add(new Point(x-i,y));	
			}
		}
		
		return moves;
	}

}
