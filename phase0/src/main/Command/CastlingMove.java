package Command;

import BoardManager.BoardManager;

/**
 *
 * PLACEHOLDER
 *
 * we might or might not need it
 *
 */
public class CastlingMove extends Move {
	public CastlingMove(BoardManager bm, ChessMove cm) {
		super(bm, cm);
	}

	/**
	 * Executes a castling move. Add ChessMove to record in MoveRecord.
	 */
	@Override
	public void execute() {
		BM.getMR().add(CM);
		// TODO implement it
	}

	/**
	 * Undo a castling move. Remove this ChessMove from record in MoveRecord.
	 */
	@Override
	public void undo() {
		BM.getMR().remove();
		// TODO implement it
	}
}
