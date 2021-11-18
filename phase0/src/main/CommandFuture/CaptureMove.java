package CommandFuture;

import Board.Board;
import BoardManager.SuperBoardManager;

/**
 *
 *
 * IN PROGRESS
 *
 */
public class CaptureMove extends Move{

	protected final String targetPiece;

	public CaptureMove(Board board, int oldX, int oldY, int newX, int newY) {
		super(board, oldX, oldY, newX, newY);
		targetPiece = board.getPiece(newX, newY);
	}

	public String getTargetPiece(){
		return targetPiece;
	}

	@Override
	public void execute() {
		board.addPiece(actionPiece, newPosition.x, newPosition.y);
		board.removePiece(oldPosition.x, oldPosition.y);
		// TODO Perhaps also deduct hp
	}

	@Override
	public void undo() {
		// Add piece back
		board.addPiece(actionPiece, oldPosition.x, oldPosition.y);
		board.addPiece(targetPiece, newPosition.x, newPosition.y);

		// Restore hp
		((SuperBoardManager) boardManager).deductOrAddHp(oldPosition[0], oldPosition[1],
				newPosition[0], newPosition[1], false);
	}

}
