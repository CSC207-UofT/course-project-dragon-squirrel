/**
 * Like it said, sends commands from player
 */
public class CommandSender {

	private BoardManager bm;
	private GameRule gl;    // A set of rules that determines valid move and piece interactions

	public CommandSender() {
		startNewGame();
	}

	/**
	 * Move the piece that is at board[oldX][oldY] to board[newX][newY]
	 * Check whether the movement is valid and possibly attack another piece
	 * @return  If successfully moved, return true
	 */
	public boolean movePiece(int oldX, int oldY, int newX, int newY) {

		if (gl.isMoveValid(oldX, oldY, newX, newY)) {
			bm.movePiece(oldX, oldY, newX, newY);
			return true;
		} else
			return false;

		/**
		 *  I moved and separated clearValidPath() into two methods
		 *  Use gl.isPathClear() and gl.isCoordinateVacant() instead
		 */
//        int clearValid = gl.clearValidPath(oldX, oldY, newX, newY);
//        if (clearValid == 0) {
//            Piece p = board.removePiece(oldX, oldY);
//            board.addPiece(p, newX, newY);
//            return true;
//        }
//
//        if (clearValid == 1) {
//            board.addPiece();
//            return true;
//        }
//
//        if (clearValid == 2)
//            return false;
//        else {
//            //code for knights and other stuff
//        }
//
//        return false;

//        if (isValidMove()) {
//            board.addPiece();
//            board.removePiece();
//        }
	}

	/**
	 * End a player's round, and let the other player move
	 */
	public void passRound() {

	}

	/**
	 * If opponent is too strong u can give up lol
	 */
	public void giveUp() {

	}

	public void startNewGame() {
		bm = new BoardManager();
		gl = new GameRule();
	}

	/**
	 * This returns an update to whatever in the upper layer
	 *
	 * Depends on the implementation, it could return different things:
	 * ex. a full image (doesn't have to be a picture) of the current board, and players can see it directly
	 * ex. updates/changes from the last round, so UI handles the update info and shows the correct things
	 */
	public Object getBoardUpdate() {
		return null;
	}

	private boolean isValidMove(int X, int Y) {
		// ....
		return false;
	}
}
