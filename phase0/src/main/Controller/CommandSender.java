package Controller;

import BoardManager.*;
import Command.*;
import GameRule.*;

import java.awt.Point;
import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Like it said, sends commands from player
 */
public class CommandSender {

	private BoardManager bm;
	private GameRule gr;    // A set of rules that determines valid move and piece interactions
	private BoardUpdater bu;

	public CommandSender(boolean classic) {
		startNewGame(classic);
	}

	public BoardUpdater getBoardUpdater() {
		return this.bu;
	}

	public BoardManager getBm() {
		return bm;
	}

	/**
	 * @return ChessMove, null if MoveType is INVALID
	 */
	public ChessMove createNewChessMove(int oldX, int oldY, int newX, int newY){
		MoveType moveType = gr.isMoveValid(oldX, oldY, newX, newY);

		if (moveType != MoveType.INVALID) {
			boolean firstMove = !bm.getHasMovedStatus(bm.getPiece(oldX, oldY));
			return new ChessMove(bm, oldX, oldY, newX, newY, firstMove, moveType);
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

			if (moveType == MoveType.EN_PASSANT) {
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
	 * Try to execute the move. Catch NullPointerException when new ChessMove is null because move is invalid.
	 * @return true if Move was executed, false otherwise.
	 */
	public boolean pressMove(int oldX, int oldY, int newX, int newY){
		ChessMove newChessMove = createNewChessMove(oldX, oldY, newX, newY);
		Move newMove = createNewMove(bm, newChessMove);
		try {
			newMove.execute();
			return true;
		} catch (NullPointerException e){
			return false;
		}
	}

	/**
	 * Try to undo move or attack. Catch NoSuchElementException when game can't be undone any further.
	 * @return true if undo success, false otherwise
	 */
	public boolean undoMove(){
		try {
			Move move = createNewMove(bm, bm.getMR().get());
			move.undo();
			return true;
		}
		catch (NoSuchElementException e){
			return false;
		}
	}

	/**
	 * @param classic true if the game played is a classic game
	 */
	public void startNewGame(boolean classic) {
		if (classic) {
			bm = new BoardManager();
			gr = new GameRule(bm.getBoard(), bm.getMR());
			this.bu = new BoardUpdater(bm);
		}
		else {
			bm = new SuperBoardManager();
			gr = new SuperGameRule(bm.getBoard(), bm.getMR());
			this.bu = new BoardUpdater((SuperBoardManager) bm);
		}
	}

	/**
	 * Ask GameRule for the valid moves
	 */
	public List<Point> passValidMove(Point p) {
		return gr.getAvailableMoves(p);
	}

	/**
	 * Serialize and save the current game info
	 */
	public void saveGame() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saveGame.txt"));
			oos.writeObject(bm);
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Deserialize and load the previous saved game
	 */
	public void loadGame() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saveGame.txt"));
			BoardManager loadedBM = (BoardManager) ois.readObject();

			this.bm = loadedBM;
			gr.loadBoardManager(loadedBM);
			bu.loadBoardManager(loadedBM);

			ois.close();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
	}
}
