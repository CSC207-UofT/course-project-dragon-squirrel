package command;

import board.BoardManager;
import board.BoardUpdater;
import rule.GameRule;

/**
 * Like it said, sends commands from player
 */
public class CommandSender {

	private BoardManager bm;
	private GameRule gl;    // A set of rules that determines valid move and piece interactions
	private BoardUpdater bu;

	public CommandSender() {

		startNewGame();
	}

	public BoardUpdater getBoardUpdater() {
		return this.bu;
	}

	public ChessMove creatNewChessMove(int oldX, int oldY, int newX, int newY){
		if (gl.isMoveValid(oldX, oldY, newX, newY)){
			return new ChessMove(bm, oldX, oldY, newX, newY);
		}
		else {
			return null;
		}
	}

	public void pressMove(ChessMove newChessMove){
		Move newMove = new Move(bm, newChessMove);
		try {
			newMove.execute();
		}catch (NullPointerException e){
			System.out.println("Invalid Move");
		}
	}

	public void pressUndo(){
		Move newMove = new Move(bm);
		newMove.undo();
	}

	/**
	 * Move the piece that is at board[oldX][oldY] to board[newX][newY]
	 * Check whether the movement is valid and possibly attack another piece
	 * @return  If successfully moved, return true
	 */
	public boolean makeMove(int oldX, int oldY, int newX, int newY) {

		if (gl.isMoveValid(oldX, oldY, newX, newY)) {
			bm.movePiece(oldX, oldY, newX, newY);
			return true;
		} else
			return false;
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
		gl = new GameRule(bm.getBoard(), bm.getPieces(), bm.getMR());
		this.bu = new BoardUpdater(bm);
	}

	/**
	 * This returns an update to whatever in the upper layer
	 *
	 * Depends on the implementation, it could return different things:
	 * ex. a full image (doesn't have to be a picture) of the current board, and players can see it directly
	 * ex. updates/changes from the last round, so UI handles the update info and shows the correct things
	 */
	public void getBoardUpdate() {
		bu.display();
	}
}
