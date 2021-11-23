package piece;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import Board.BoardInterface;

public class King extends Piece{

    public boolean hasMovedDuringGame;

    public King(String name, Color color){
        super(name, color);
    }

	@Override
	public int getValue() {
		return KING_VALUE;
	}

	@Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) <= 1 && Math.abs(oldCoorY - newCoorY) <= 1;

        //TODO: what if we are castling
    }
    
	public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		List<Point> moves = new ArrayList<>();

		//checking in all directions
		//The king can move one space in any direction

		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if ((i == x && j == y) || !withinBoundary(i, j, b))
					continue;
				if (b.isPositionVacant(i, j) || isOpponentPiece(i, j, b))
					moves.add(new Point(i, j));
			}
		}
	
		if(color == Color.WHITE) {			
			if (!this.hasMovedDuringGame && x == 4 && y == 0) {
				if(b.isPositionVacant(5, 0) && b.isPositionVacant(6, 0) && !b.isPositionVacant(7, 1-1) && b.getPiece(7, 1-1) instanceof Rook){
					moves.add(new Point(x+2,y));
				}
			}
			else 
				this.hasMovedDuringGame = true;
		}
		else { 
			if (!this.hasMovedDuringGame && x == 4 && y == 7) {
				
			}
			else 
				this.hasMovedDuringGame = true;
		}

		return moves;
	}

}
