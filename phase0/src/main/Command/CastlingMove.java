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
	 * Executes a castling move by moving the king and the rook to their new positions in board and removing them from
	 * their old position in board. Switch the hasMoved status of the king and the rook to true.
	 * Add ChessMove to record in MoveRecord.
	 */
	@Override
	public void execute() {
		BM.getMR().add(CM);
		BM.switchChessTimer();
		BM.gameStatus();
		BM.switchActivePlayer();

		BM.getBoard().addPiece(actionPiece, CM.getNewX(), CM.getNewY());
		BM.getBoard().removePiece(CM.getOldX(), CM.getOldY());
		BM.getBoard().addPiece(CM.getOtherPiece(), CM.getNewX(), (CM.getNewY() == 6)? 5 : 3);
		BM.getBoard().removePiece(CM.getNewX(), (CM.getNewY() == 6)? 7 : 0);

		BM.switchPieceHasMovedStatus(actionPiece, true);
		BM.switchPieceHasMovedStatus(CM.getOtherPiece(), true);
	}

	/**
	 * Undo a castling move. Switch the hasMoved status of the king and the rook back to false.
	 * Remove this ChessMove from record in MoveRecord.
	 */
	@Override
	public void undo() {
		BM.getMR().remove();
		BM.switchActivePlayer();
		BM.switchChessTimer();

		BM.getBoard().addPiece(CM.getOldPiece(), CM.getOldX(), CM.getOldY());
		BM.getBoard().removePiece(CM.getNewX(), CM.getNewY());

		// undo castling rook
		BM.getBoard().addPiece(CM.getOtherPiece(), CM.getNewX(), (CM.getNewY() == 6)? 7 : 0);
		BM.getBoard().removePiece(CM.getNewX(), (CM.getNewY() == 6)? 5 : 3);

		BM.switchPieceHasMovedStatus(actionPiece, false);
		BM.switchPieceHasMovedStatus(CM.getOtherPiece(), false);
	}
}
