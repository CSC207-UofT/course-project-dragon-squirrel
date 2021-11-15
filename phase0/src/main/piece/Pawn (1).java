import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import Board.Board;

package piece;

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
    
	public List<Point> GetValidMoves(Board b, int x, int y) {
		List<Point> moves = new ArrayList<Point>();
		
		//pawn moves forward , not backward so checking for white and black separately
		if(color == Color.WHITE) {
			if(x < b.getBoundaries().x && (y+1) < b.getBoundaries().y && b.isPositionVacant(x, y+1)) {
				moves.add(new Point(x,y+1));
			}

			if(x+1 < b.getBoundaries().x && (y+1) < b.getBoundaries().y && !b.isPositionVacant(x+1, y+1) && ((b.getPiece(x+1, y+1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+1, y+1).charAt(0) == 'w' && color == Color.BLACK))) {
				moves.add(new Point(x+1,y+1));
			}
			if(x-1 < b.getBoundaries().x && (y+1) < b.getBoundaries().y && !b.isPositionVacant(x-1, y+1) && ((b.getPiece(x-1, y+1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-1, y+1).charAt(0) == 'w' && color == Color.BLACK))) {
				moves.add(new Point(x-1,y+1));
			}
		}
		else {
			if(x < b.getBoundaries().x && (y-1) < b.getBoundaries().y && b.isPositionVacant(x, y-1)) {
				moves.add(new Point(x,y-1));
			}

			if(x+1 < b.getBoundaries().x && (y-1) < b.getBoundaries().y && !b.isPositionVacant(x+1, y-1) && ((b.getPiece(x+1, y-1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+1, y-1).charAt(0) == 'w' && color == Color.BLACK))) {
				moves.add(new Point(x+1,y-1));
			}
			if(x-1 < b.getBoundaries().x && (y-1) < b.getBoundaries().y && !b.isPositionVacant(x-1, y-1) && ((b.getPiece(x-1, y-1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-1, y-1).charAt(0) == 'w' && color == Color.BLACK))) {
				moves.add(new Point(x-1,y-1));
			}
		}
		
		return moves;
	}
	
}
