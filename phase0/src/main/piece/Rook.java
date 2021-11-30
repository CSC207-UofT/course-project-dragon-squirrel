package piece;
import java.util.ArrayList;

import java.util.List;
import java.awt.Point;
import Board.BoardInterface;
public class Rook extends Piece{

    private boolean hasMovedDuringGame;

    public Rook(String name, Color color){
        super(name, color);
    }

	/**
	 * @return true if Rook has moved during the game, false otherwise.
	 */
	public boolean getHasMovedDuringGame(){
		return hasMovedDuringGame;
	}

	/**
	 * Set hasMovedDuringGame as true or false depending on hasMoved.
	 */
	public void setHasMovedDuringGame(boolean hasMoved){
		hasMovedDuringGame = hasMoved;
	}

	@Override
	public int getValue() {
		return ROOK_VALUE;
	}

	/**
	 * Check: move is a straight horizontal or vertical line.
	 * @return true if move is valid according to rook behaviour, false otherwise.
	 */
	@Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        return Math.abs(oldX - newX) == 0 || Math.abs(oldY - newY) == 0;
    }

	/**
	 * @return a List<Point> of the valid coordinates the rook can move to given piece behaviour, game rules, and
	 * present board state.
	 */
    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		List<Point> moves = new ArrayList<>();
		//Rooks move up and down the rank and file of the chessboard, and can move any number of spaces
		
		boolean right = true;
		boolean left = true;
		boolean up = true;
		boolean down = true;
		
		for(int i = 1; i < b.getBoundaries().x; i++) {
			
			if(withinBoundary(x, y+i, b) && right) {		//right
				if(!b.isPositionVacant(x, y + i)) {
					if(isOpponentPiece(x, y+i, b))
						moves.add(new Point(x,y+i));						
					right = false;
				}
				else
					moves.add(new Point(x,y+i));	
			}
			
			if(withinBoundary(x, y-i, b) && left) {			//left
				if(!b.isPositionVacant(x, y - i)) {
					if(isOpponentPiece(x, y-i, b))
						moves.add(new Point(x,y-i));	
					left = false;
				}
				else
					moves.add(new Point(x,y-i));	
			}
			
			if(withinBoundary(x+i, y, b) && down) {			//down
				if(!b.isPositionVacant(x + i, y)) {
					if(isOpponentPiece(x+i, y, b))
						moves.add(new Point(x+i,y));	
					down = false;
				}
				else
					moves.add(new Point(x+i,y));	
			}
			
			if(withinBoundary(x-i, y, b) && up) {			//up
				if(!b.isPositionVacant(x - i, y)) {
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

	@Override
	public Piece deepCopy() {
		Rook newPiece = new Rook(name, color);
		newPiece.status = this.status;
		return newPiece;
	}

}
