package piece;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import Board.Board;
import Board.BoardInterface;


public class Pawn extends Piece{

    public boolean hasNotMovedDuringGame;

    public Pawn(String name, Color color){
        super(name, color);
        hasNotMovedDuringGame = true;
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        boolean solution;
        if (color == Color.WHITE) {
            solution = ((newCoorX - oldCoorX == -1 && newCoorY - oldCoorY == 0));
        }
        else {
            solution = ((newCoorX - oldCoorX == 1 && newCoorY - oldCoorY == 0));
        }
        if (solution) {
            return true;
        }
        if (hasNotMovedDuringGame) {
            if (color == Color.WHITE) {
                solution = (newCoorX - oldCoorX == -2 && newCoorY - oldCoorY == 0);
            }
            else {
                solution = (newCoorX - oldCoorX == 2 && newCoorY - oldCoorY == 0);
            }
        }

        return solution;
    }
    
    @Override
	public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		List<Point> moves = new ArrayList<Point>();
		
		//pawn moves forward , not backward so checking for white and black separately
		if(color == Color.WHITE) {
			if(withinBoundary(x, y+1, b) && b.isPositionVacant(x, y+1)) {
				moves.add(new Point(x,y+1));
			}

			if(withinBoundary(x+1, y+1, b) && !b.isPositionVacant(x+1, y+1) && isOpponentPiece(x+1, y+1, b)) {
				moves.add(new Point(x+1,y+1));
			}

			if(withinBoundary(x-1, y+1, b) && !b.isPositionVacant(x-1, y+1) && isOpponentPiece(x-1, y+1, b)) {
				moves.add(new Point(x-1,y+1));
			}
		}
		else {
			if(withinBoundary(x, y-1, b) && b.isPositionVacant(x, y-1)) {
				moves.add(new Point(x,y-1));
			}

			if(withinBoundary(x+1, y-1, b) && !b.isPositionVacant(x+1, y-1) && isOpponentPiece(x+1, y-1, b)) {
				moves.add(new Point(x+1,y-1));
			}
			
			if(withinBoundary(x-1, y-1, b) && !b.isPositionVacant(x-1, y-1) && isOpponentPiece(x-1, y-1, b)) {
				moves.add(new Point(x-1,y-1));
			}
		}
		
		return moves;
	}
	
}
