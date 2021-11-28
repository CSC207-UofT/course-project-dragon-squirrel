package piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import Board.Board;
import Board.BoardInterface;


public class Knight extends Piece{

    public Knight(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        int X = Math.abs(oldCoorX - newCoorX);
        int Y = Math.abs(oldCoorY - newCoorY);
        return (X == 2 && Y == 1) || (X == 1 && Y == 2);
    }
    
    public boolean isEmptyOrValid(int x, int y, BoardInterface b) {
    	return (b.isPositionVacant(x,y) || (!b.isPositionVacant(x,y) && isOpponentPiece(x, y, b)));
    }
    
    
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y){
    	List<Point> moves = new ArrayList<Point>();
		
		// Knight move in L-shaped
		
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
}
