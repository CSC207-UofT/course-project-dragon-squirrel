package piece;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import Board.BoardInterface;


public class Pawn extends Piece{

    public boolean hasNotMovedDuringGame;

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
	 * Pawn moves forward, not backward
	 * black and white pawn moves to different direction
	 * Caution, this does NOT check en passant
	 *
	 * @param b The board
	 * @param x starting position x
	 * @param y starting position x
	 * @return  All the valid moves
	 */
    @Override
	public List<Point> getValidMoves(BoardInterface b, int x, int y) {
	    List<Point> moves = new ArrayList<>();
	    int direction = (color == Color.WHITE) ? -1 : 1;  // This is indicator, can either be 1 or -1

	    int oneStepForward = x + direction;
	    int twoStepsForward = x + direction * 2;

	    if (canMoveTo(oneStepForward, y, b)) {
		    moves.add(new Point(oneStepForward,y));
	    }

	    if (canMoveTo(oneStepForward, y, b) && canMoveTo(twoStepsForward, y, b) && hasNotMovedDuringGame) {
		    moves.add(new Point(x + direction * 2,y));
	    }

	    if(canCapture(oneStepForward, y+1, b)) {
		    moves.add(new Point(oneStepForward,y+1));
	    }

	    if(canCapture(oneStepForward, y-1, b)) {
		    moves.add(new Point(oneStepForward,y-1));
	    }

	    return moves;
	}

	private boolean canCapture(int x, int y, BoardInterface b) {
		return withinBoundary(x, y, b) && !b.isPositionVacant(x, y) && isOpponentPiece(x, y, b);
	}

	private boolean canMoveTo(int x, int y, BoardInterface b) {
		return withinBoundary(x, y, b) && b.isPositionVacant(x, y);
	}

	@Override
	public Piece deepCopy() {
		Pawn newPiece = new Pawn(name, color);
		newPiece.status = this.status;
		newPiece.hasNotMovedDuringGame = this.hasNotMovedDuringGame;
		return newPiece;
	}

}
