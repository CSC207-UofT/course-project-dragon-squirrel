package Command;

import BoardManager.BoardManager;
import piece.SuperPieceDecorator;

public class CaptureMove extends Move {

	protected int hpDeduction;

	public CaptureMove(BoardManager bm, ChessMove cm) {
		super(bm, cm);

		try {
			hpDeduction = ((SuperPieceDecorator) actionPiece).getAtk();
		} catch (ClassCastException e) {
			hpDeduction = 0;
		}
	}

	/**
	 * Executes a capture. Add ChessMove to record in MoveRecord.
	 * If capture happened after an attack, set hp of captured piece to 0.
	 */
	@Override
	public void execute() {
		BM.getMR().add(CM);
		BM.getBoard().addPiece(actionPiece, CM.getNewX(), CM.getNewY());
		BM.getBoard().removePiece(CM.getOldX(), CM.getOldY());

		if (hpDeduction != 0) {
			((SuperPieceDecorator) targetPiece).modifyHp(-hpDeduction);
		}
	}

	/**
	 * Undo a capture. Remove this ChessMove from record in MoveRecord.
	 * If capture happened after an attack, set hp of captured piece back to before it was captured.
	 */
	@Override
	public void undo() {
		BM.getMR().remove();
		// Add piece back
		BM.getBoard().addPiece(actionPiece, CM.getOldX(), CM.getOldY());
		BM.getBoard().addPiece(targetPiece, CM.getNewX(), CM.getNewY());

		if (hpDeduction != 0) {
			((SuperPieceDecorator) targetPiece).modifyHp(hpDeduction);
		}
	}

}
