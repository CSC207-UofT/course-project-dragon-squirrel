package piece;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
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

		for(int i = 1; i < b.getBoundaries().x; i++) {
			if(x < b.getBoundaries().x && (y+i) < b.getBoundaries().y) {
				if(b.isPositionVacant(x, y+i) == false) {
					if((b.getPiece(x, y+i).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x, y+i).charAt(0) == 'w' && color == Color.BLACK))
						moves.add(new Point(x,y+i));	
					
					break;
				}
				else
					moves.add(new Point(x,y+i));	
			}
		}
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if(x < b.getBoundaries().x && (y-i) < b.getBoundaries().y) {
				if(b.isPositionVacant(x, y-i) == false) {
					if((b.getPiece(x, y-i).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x, y-i).charAt(0) == 'w' && color == Color.BLACK))
						moves.add(new Point(x,y-i));	
					
					break;
				}
				else
					moves.add(new Point(x,y-i));	
			}
		}
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if(x+i < b.getBoundaries().x && y < b.getBoundaries().y) {
				if(b.isPositionVacant(x+i, y) == false) {
					if((b.getPiece(x+i, y).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x+i, y).charAt(0) == 'w' && color == Color.BLACK))
						moves.add(new Point(x+i,y));	
					
					break;
				}
				else
					moves.add(new Point(x+i,y));	
			}
		}
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if(x-i < b.getBoundaries().x && y < b.getBoundaries().y) {
				if(b.isPositionVacant(x-i, y) == false) {
					if((b.getPiece(x-i, y).charAt(0) == 'b' && color == Color.WHITE) || (b.getPiece(x-i, y).charAt(0) == 'w' && color == Color.BLACK))
						moves.add(new Point(x-i,y));	
					
					break;
				}
				else
					moves.add(new Point(x-i,y));	
			}
		}
		
		return moves;
	}

}
