package piece;

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
		//Rooks move up and down the rank and file of the chessboard, and can move any number of spaces
	    return searchHorizontalAndVertically(b, x, y);
	}

	@Override
	public Piece deepCopy() {
		Rook newPiece = new Rook(name, color);
		newPiece.status = this.status;
		return newPiece;
	}

}
