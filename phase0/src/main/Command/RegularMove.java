package Command;


import BoardManager.BoardManager;

public class RegularMove extends Move {
	public RegularMove(BoardManager bm, ChessMove cm) {
		super(bm, cm);
	}

	/**
	 * Executes a regular move. Add ChessMove to record in MoveRecord.
	 */
	@Override
	public void execute() {
		BM.getMR().add(CM);
		BM.getBoard().addPiece(actionPiece, CM.getNewX(), CM.getNewY());
		BM.getBoard().removePiece(CM.getOldX(), CM.getOldY());
	}

	/**
	 * Undo a regular move by adding piece back to its previous position.
	 * Remove this ChessMove from record in MoveRecord.
	 */
	@Override
	public void undo() {
		BM.getMR().remove();

		BM.getBoard().addPiece(actionPiece, CM.getOldX(), CM.getOldY());
		BM.getBoard().removePiece(CM.getNewX(), CM.getNewY());
	}
}
