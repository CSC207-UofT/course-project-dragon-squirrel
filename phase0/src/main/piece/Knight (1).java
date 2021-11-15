import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import Board.Board;

package piece;

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
    
    @Override
    public List<Point> GetValidMoves(Board b, int x, int y){
    	List<Point> moves = new ArrayList<Point>();
		
		// Knight move in L-shaped
		if((x+1) < b.getBoundaries().x && (y+2) < b.getBoundaries().y && (b.isPositionVacant(x+1,y+2) || (!b.isPositionVacant(x+1,y+2) && (b.getPiece(x+1,y+2).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+1,y+2).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x+1,y+2));
		}
		
		if((x+2) < b.getBoundaries().x && (y+1) < b.getBoundaries().y && (b.isPositionVacant(x+2,y+1) || (!b.isPositionVacant(x+2,y+1) && (b.getPiece(x+2,y+1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+2,y+1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x+2,y+1));
		}
		
		if((x+2) < b.getBoundaries().x && (y-1) < b.getBoundaries().y && (b.isPositionVacant(x+2,y-1) || (!b.isPositionVacant(x+2,y-1) && (b.getPiece(x+2,y-1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+2,y-1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x+2,y-1));
		}

		if((x+1) < b.getBoundaries().x && (y-2) < b.getBoundaries().y && (b.isPositionVacant(x+1, y-2) || (!b.isPositionVacant(x+1, y-2) && (b.getPiece(x+1, y-2).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+1, y-2).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x+1, y-2));
		}

		if(x-1 < b.getBoundaries().x && (y-2) < b.getBoundaries().y && (b.isPositionVacant(x-1,y-2) || (!b.isPositionVacant(x-1,y-2) && (b.getPiece(x-1,y-2).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-1,y-2).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x-1,y-2));
		}
		
		if((x-2) < b.getBoundaries().x && (y-1) < b.getBoundaries().y && (b.isPositionVacant(x-2,y-1) || (!b.isPositionVacant(x-2,y-1) && (b.getPiece(x-2,y-1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-2,y-1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x-2,y-1));
		}

		if((x-2) < b.getBoundaries().x && (y+1) < b.getBoundaries().y && (b.isPositionVacant(x-2,y+1) || (!b.isPositionVacant(x-2,y+1) && (b.getPiece(x-2,y+1).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-2,y+1).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x-2,y+1));
		}
		
		if((x-1) < b.getBoundaries().x && (y+2) < b.getBoundaries().y && (b.isPositionVacant(x-1,y+2) || (!b.isPositionVacant(x-1,y+2) && (b.getPiece(x-1,y+2).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-1,y+2).charAt(0) == 'w' && color == Color.BLACK)))) {
			moves.add(new Point(x-1,y+2));
		}
	
		return moves;
    }
}
