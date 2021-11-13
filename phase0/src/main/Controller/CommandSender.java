package Controller;

import BoardManager.*;
import Command.ChessMove;
import Command.Move;
import GameRule.*;

/**
 * Like it said, sends commands from player
 */
public class CommandSender {

	private BoardManager bm;
	private GameRule gl;    // A set of rules that determines valid move and piece interactions
	private BoardUpdater bu;

	public CommandSender(boolean classic) {
		startNewGame(classic);
	}

	public BoardUpdater getBoardUpdater() {
		return this.bu;
	}

	public ChessMove creatNewChessMove(int oldX, int oldY, int newX, int newY){
		int moveType = moveType(oldX, oldY, newX, newY);
		if (moveType > 0){
			return new ChessMove(bm, oldX, oldY, newX, newY, moveType);
		} else {
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
	/**
	 * @return 	-1 if move or attack is invalid <P>
	 * 			1 if attack is valid <P>
	 * 			2 if move is valid <P>
	 * 			3 if move is valid after a successful attack
	 */
	public int moveType(int oldX, int oldY, int newX, int newY) {
		if (!gl.isMoveValid(oldX, oldY, newX, newY)) {
			return -1;
		}
		// if there is an attack: target coordinate has an opponent's piece
		if (gl instanceof SuperGameRule && bm instanceof SuperBoardManager){
			if (((SuperGameRule) gl).isAttackAvailable(oldX, oldY, newX, newY)){
				if (!((SuperGameRule) gl).isAttackValid(oldX, oldY, newX, newY)){
					return -1;
				}
				boolean attackedToDeath = ((SuperBoardManager) bm).attackToDeath(oldX, oldY, newX, newY);
				if (attackedToDeath) {
					System.out.println("attacked to death");
					return 3;
				} return 1;
			}
		} return 2;
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

	/**
	 * @param classic true if the game played is a classic game
	 */
	public void startNewGame(boolean classic) {
		if (classic) {
			bm = new BoardManager();
			gl = new GameRule(bm.getBoard(), bm.getPieces(), bm.getMR());
		}
		else {
			bm = new SuperBoardManager();
			gl = new SuperGameRule(bm.getBoard(), bm.getPieces(), bm.getMR());
		}
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
