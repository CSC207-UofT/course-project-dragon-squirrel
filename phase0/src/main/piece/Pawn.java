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

	@Override
	public int getValue() {
		return PAWN_VALUE;
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

	    if (canMoveTo(oneStepForward, y, b)) {
		    moves.add(new Point(oneStepForward,y));
	    }

	    if (canMoveTo(x + direction * 2, y, b) && hasNotMovedDuringGame) {
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
