package CommandFuture;

import BoardManager.BoardManager;

public class RegularMove extends Move{
	public RegularMove(BoardManager newBM, int oldX, int oldY, int newX, int newY) {
		super(newBM, oldX, oldY, newX, newY);
	}

	@Override
	public void execute() {
		super.boardManager.movePiece(oldPosition[0], oldPosition[1], newPosition[0], newPosition[1]);
	}

	@Override
	public void undo() {
		boardManager.movePiece(newPosition[0], newPosition[1], oldPosition[0], oldPosition[1]);
	}
}
