package piece;

import java.util.ArrayList;

import java.util.List;
import java.awt.*;
import Board.BoardInterface;


public class Bishop extends Piece{

    public Bishop(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == Math.abs(oldCoorY - newCoorY);
    }
    
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y)
    {
		List<Point> moves = new ArrayList<Point>();

		//Bishop can move in diagonals
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if((x+i) < b.getBoundaries().x && (y+i) < b.getBoundaries().y) {
				
				if(!b.isPositionVacant(x + i, y + i)) {
				
					if((b.getPiece(x+i, y+i).isBlack() && color == Color.WHITE) || (b.getPiece(x+i, y+i).isWhite() && color == Color.BLACK))
						moves.add(new Point(x+i,y+i));	
					
					break;
				}
				else
					moves.add(new Point(x+i,y+i));	
			}
		}
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if((x-i) < b.getBoundaries().x && (y+i) < b.getBoundaries().y) {
				
				if(!b.isPositionVacant(x-i, y+i)) {
				
					if((b.getPiece(x-i, y+i).isBlack() && color == Color.WHITE) || (b.getPiece(x-i, y+i).isWhite() && color == Color.BLACK))
						moves.add(new Point(x-i,y+i));	
					
					break;
				}
				else
					moves.add(new Point(x-i,y+i));	
			}
		}
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if((x+i) < b.getBoundaries().x && (y-i) < b.getBoundaries().y) {
				
				if(!b.isPositionVacant(x+i, y-i)) {
				
					if((b.getPiece(x+i, y-i).isBlack() && color == Color.WHITE) || (b.getPiece(x+i, y-i).isWhite() && color == Color.BLACK))
						moves.add(new Point(x+i,y-i));	
					
					break;

				}
				else
					moves.add(new Point(x+i,y-i));	
			}
		}
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			if((x-i) < b.getBoundaries().x && (y-i) < b.getBoundaries().y) {
				
				if(!b.isPositionVacant(x-i, y-i)) {

					if((b.getPiece(x-i, y-i).isBlack() && color == Color.WHITE) || (b.getPiece(x-i, y-i).isWhite() && color == Color.BLACK))
						moves.add(new Point(x-i,y-i));	
					
					break;

				}
				else
					moves.add(new Point(x-i,y-i));	
			}
		}
		
		return moves;
	}

}
