package Controller;

import BoardManager.*;
import Command.*;
import GameRule.*;

import java.util.NoSuchElementException;

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

	/**
	 * @return ChessMove, null if MoveType is INVALID
	 */
	public ChessMove createNewChessMove(int oldX, int oldY, int newX, int newY){
		MoveType moveType = gl.isMoveValid(oldX, oldY, newX, newY);

		if (moveType != MoveType.INVALID) {
			return new ChessMove(bm, oldX, oldY, newX, newY, moveType);
		}
		return null;
	}

	/**
	 * Looks at the type of move in ChessMove and creates a corresponding Move.
	 * @return Move (RegularMove, AttackMove, CaptureMove, EnPassantMove, CastlingMove) or null
	 */
	public Move createNewMove(BoardManager bm, ChessMove newChessMove){

		try {
			MoveType moveType = newChessMove.getMoveType();

			if (moveType == MoveType.REGULAR) {
				return new RegularMove(bm, newChessMove);
			}

			if (moveType == MoveType.ATTACK) {
				return new AttackMove(bm, newChessMove);
			}

			if (moveType == MoveType.CAPTURE) {
				return new CaptureMove(bm, newChessMove);
			}

			if (moveType == MoveType.ENPASSANT) {
				return new EnPassantMove(bm, newChessMove);
			}

			if (moveType == MoveType.CASTLING) {
				return new CastlingMove(bm, newChessMove);
			}
		}
		catch (NullPointerException e) {
			return null;
		}
		return null;
	}

	/**
	 * @return true if Move was executed, false otherwise.
	 */
	public boolean pressMove(int oldX, int oldY, int newX, int newY){
		Move newMove = createNewMove(bm, createNewChessMove(oldX, oldY, newX, newY));
		try {
			newMove.execute();
			return true;
		}catch (NullPointerException e){
			return false;
		}
	}

	/**
	 * Undo move or attack.
	 * @return true if undo success, false otherwise
	 */
	public boolean undoMove(){
		try {
			Move move = createNewMove(bm, bm.getMR().get());
			move.undo();
			return true;
		}
		catch (NoSuchElementException e){
			System.out.println("cannot undo any further");
			return false;
		}
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
			gl = new GameRule(bm.getBoard(), bm.getMR());
		}
		else {
			bm = new SuperBoardManager();
			gl = new SuperGameRule(bm.getBoard(), bm.getMR());
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
