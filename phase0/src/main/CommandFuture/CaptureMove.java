package CommandFuture;

import BoardManager.BoardManager;
import BoardManager.SuperBoardManager;

public class CaptureMove extends Move{

	public CaptureMove(BoardManager newBM, int oldX, int oldY, int newX, int newY) {
		super(newBM, oldX, oldY, newX, newY);
	}

	@Override
	public void execute() {
		super.boardManager.movePiece(oldPosition[0], oldPosition[1], newPosition[0], newPosition[1]);
		// TODO Perhaps also deduct hp
	}

	@Override
	public void undo() {
		// Add piece back
		boardManager.movePiece(newPosition[0], newPosition[1], oldPosition[0], oldPosition[1]);
		boardManager.getBoard().addPiece(newPieceName, newPosition[0], newPosition[1]);

		// Restore hp
		((SuperBoardManager) boardManager).deductOrAddHp(oldPosition[0], oldPosition[1],
				newPosition[0], newPosition[1], false);
	}

}
