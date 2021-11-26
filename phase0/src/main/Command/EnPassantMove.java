package Command;

import BoardManager.BoardManager;
import piece.SuperPieceDecorator;

public class EnPassantMove extends Move {
	protected int hpDeduction;

	public EnPassantMove(BoardManager bm, ChessMove cm) {
		super(bm, cm);
		System.out.println("enpassant");

		try {
			hpDeduction = ((SuperPieceDecorator) actionPiece).getAtk();
		} catch (ClassCastException e) {
			hpDeduction = 0;
		}
	}

	/**
	 * Executes an enpassant by adding capturing pawn to target coordinates and removing captured pawn from the board.
	 * If enpassant move happened after a successful attack, set hp of captured pawn to 0.
	 * Add ChessMove to record in MoveRecord.
	 */
	@Override
	public void execute() {
		BM.getMR().add(CM);

		BM.getBoard().addPiece(actionPiece, CM.getNewX(), CM.getNewY());
		BM.getBoard().removePiece(CM.getOldX(), CM.getOldY());
		BM.getBoard().removePiece(CM.getOldX(), CM.getNewY());
		System.out.println(CM.getOtherPiece());

		if (hpDeduction != 0) {
			((SuperPieceDecorator) CM.getOtherPiece()).modifyHp(-hpDeduction);
		}
	}

	/**
	 * Undo an enpassant move by adding capturing pawn back to its previous position and adding captured pawn back to board.
	 * If enpassant move happened after an attack, set hp of captured pawn back to before it was captured.
	 * Remove this ChessMove from record in MoveRecord.
	 */
	@Override
	public void undo() {
		BM.getMR().remove();

		BM.getBoard().addPiece(CM.getOldPiece(), CM.getOldX(), CM.getOldY());
		BM.getBoard().removePiece(CM.getNewX(), CM.getNewY());

		// add back captured pawn
		System.out.println(CM.getOtherPiece());
		BM.getBoard().addPiece(CM.getOtherPiece(), CM.getOldX(), CM.getNewY());

		if (hpDeduction != 0) {
			((SuperPieceDecorator) CM.getOtherPiece()).modifyHp(hpDeduction);
		}
	}
}
