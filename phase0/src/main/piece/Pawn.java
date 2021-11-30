package piece;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import Board.BoardInterface;


public class Pawn extends Piece{

    private boolean hasNotMovedDuringGame;

    public Pawn(String name, Color color){
        super(name, color);
        hasNotMovedDuringGame = true;
    }

	/**
	 * @return true if Pawn has not moved during the game, false otherwise.
	 */
	public boolean getHasNotMovedDuringGame(){
		return hasNotMovedDuringGame;
	}

	/**
	 * Set hasNotMovedDuringGame as true or false depending on hasMoved.
	 */
	public void setHasNotMovedDuringGame(boolean hasNotMoved){
		hasNotMovedDuringGame = hasNotMoved;
	}

	@Override
	public int getValue() {
		return PAWN_VALUE;
	}

	/**
	 * Check: move is 1 square directly forward, or optional 2 squares directly forward if not yet moved during game.
	 * @return true if move is valid according to pawn behaviour, false otherwise.
	 */
	@Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        boolean solution;
        if (color == Color.WHITE) {
            solution = ((newX - oldX == -1 && newY - oldY == 0));
        }
        else {
            solution = ((newX - oldX == 1 && newY - oldY == 0));
        }
        if (solution) {
            return true;
        }
        if (hasNotMovedDuringGame) {
            if (color == Color.WHITE) {
                solution = (newX - oldX == -2 && newY - oldY == 0);
            }
            else {
                solution = (newX - oldX == 2 && newY - oldY == 0);
            }
        }

        return solution;
    }

	/**
	 * @return a List<Point> of the valid coordinates the pawn can move to given piece behaviour, game rules, and
	 * present board state.
	 */
    @Override
	public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		List<Point> moves = new ArrayList<>();
		
		//pawn moves forward , not backward so checking for white and black separately
		if(color == Color.WHITE) {
			if(withinBoundary(x-1, y, b) && b.isPositionVacant(x-1, y)) {
				moves.add(new Point(x-1,y));
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

	@Override
	public Piece deepCopy() {
		Pawn newPiece = new Pawn(name, color);
		newPiece.status = this.status;
		newPiece.hasNotMovedDuringGame = this.hasNotMovedDuringGame;
		return newPiece;
	}

}
