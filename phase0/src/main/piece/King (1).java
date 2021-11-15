import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import Board.Board;

package piece;

public class King extends Piece{

    public boolean hasMovedDuringGame;

    public King(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) <= 1 && Math.abs(oldCoorY - newCoorY) <= 1;

        //TODO: what if we are castling
    }
    
	public List<Point> GetValidMoves(Board b, int x, int y) {
		List<Point> moves = new ArrayList<Point>();
		
		//checking in all directions
		//The king can move one space in any direction
		
		if((x-1) < b.getBoundaries().x && (y-1) < b.getBoundaries().y && (b.isPositionVacant(x-1,y-1) || (!b.isPositionVacant(x-1,y-1) && (b.getPiece(x-1,y-1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-1, y-1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x-1,y-1));
		}
		
		if((x+1) < b.getBoundaries().x && (y) < b.getBoundaries().y && (b.isPositionVacant(x+1,y) || (!b.isPositionVacant(x+1,y) && (b.getPiece(x+1,y).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+1, y).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x+1,y));
		}
		
		if((x+1) < b.getBoundaries().x && (y-1) < b.getBoundaries().y && (b.isPositionVacant(x+1,y-1) || (!b.isPositionVacant(x+1,y-1) && (b.getPiece(x+1,y-1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+1, y-1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x+1,y-1));
		}

		if((x+1) < b.getBoundaries().x && (y+1) < b.getBoundaries().y && (b.isPositionVacant(x+1, y+1) || (!b.isPositionVacant(x+1,y+1) && (b.getPiece(x+1,y+1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+1, y+1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x+1,y+1));
		}

		if(x < b.getBoundaries().x && (y-1) < b.getBoundaries().y && (b.isPositionVacant(x,y-1) || (!b.isPositionVacant(x,y-1) && (b.getPiece(x,y-1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x, y-1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x,y-1));
		}
		
		if((x-1) < b.getBoundaries().x && (y) < b.getBoundaries().y && (b.isPositionVacant(x-1,y) || (!b.isPositionVacant(x-1,y) && (b.getPiece(x-1,y).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-1, y).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x-1,y));
		}

		if((x-1) < b.getBoundaries().x && (y+1) < b.getBoundaries().y && (b.isPositionVacant(x-1,y+1) || (!b.isPositionVacant(x-1,y+1) && (b.getPiece(x-1,y+1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-1, y+1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x-1,y+1));
		}
		
		if((x) < b.getBoundaries().x && (y+1) < b.getBoundaries().y && (b.isPositionVacant(x,y+1) || (!b.isPositionVacant(x,y+1) && (b.getPiece(x,y+1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x, y+1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x,y+1));
		}
	
		if(color == Color.WHITE) {			
			if(this.hasMovedDuringGame == false && x == 4 && y == 0) {
				if(b.isPositionVacant(5, 0) && b.isPositionVacant(6, 0) && !b.isPositionVacant(7, 1-1) && b.getPiece(7, 1-1).charAt(2) == 'r'){
					moves.add(new Point(x+2,y));
				}	
						
			}
			else 
				this.hasMovedDuringGame = true;
		}
		else { 
			if(!this.hasMovedDuringGame && x == 4 && y == 7) {
				
			}
			else 
				this.hasMovedDuringGame = true;
		}		
		return moves;
	}

}
