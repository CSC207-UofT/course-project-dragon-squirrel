package piece;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import Board.BoardInterface;

public class King extends Piece{

    private boolean hasMovedDuringGame;

    public King(String name, Color color){
        super(name, color);
		hasMovedDuringGame = false;
    }

	/**
	 * @return true if King has moved during the game, false otherwise.
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
		return KING_VALUE;
	}

	/**
	 * Check: move is one square in any direction, or follows castling behaviour (two squares left or right given king
	 * has not yet moved during the game)
	 * @return true if move is valid according to king behaviour, false otherwise.
	 */
	@Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
		if (!hasMovedDuringGame) { //Castling
			if (getColor() == Color.BLACK && oldX == 0 && oldY == 4 && newX == 0 && (newY == 2 || newY == 6)){
				return true;
			} if (getColor() == Color.WHITE && (oldX == 7 && oldY == 4 && newX == 7 && (newY == 2 || newY == 6))){
				return true;
			}
		}
		// regular movement
		return Math.abs(oldX - newX) <= 1 && Math.abs(oldY - newY) <= 1;
	}

	/**
	 * @return a List<Point> of the valid coordinates the king can move to given piece behaviour, game rules, and
	 * present board state.
	 */
	@Override
	public List<Point> getValidMoves(BoardInterface b, int x, int y) {
		List<Point> moves = new ArrayList<>();

		//The king can move one space in any direction
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
				if (i == x && j == y)
					continue;
				if (isValidToMove(i, j, b))
					moves.add(new Point(i, j));
			}
		}

		if (!hasMovedDuringGame) {
			if (b.isPositionVacant(x, 5) && b.isPositionVacant(x, 6) && (b.getPiece(x, 7) instanceof Rook) &&
					!((Rook) b.getPiece(x, 7)).getHasMovedDuringGame()) {
				moves.add(new Point(x, 6));
			} if (b.isPositionVacant(x, 3) && b.isPositionVacant(x, 2) && b.isPositionVacant(x, 1) &&
					(b.getPiece(x, 0) instanceof Rook) && !((Rook) b.getPiece(x, 0)).getHasMovedDuringGame()) {
				moves.add(new Point(x, 2));
			}
		}

		return moves;
	}

	@Override
	public Piece deepCopy() {
		King newPiece = new King(name, color);
		newPiece.status = this.status;
		newPiece.hasMovedDuringGame = this.hasMovedDuringGame;
		return newPiece;
	}

}
