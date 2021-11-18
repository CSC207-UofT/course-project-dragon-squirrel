package CommandFuture;

import BoardManager.BoardManager;

public class CastlingMove extends Move{
	public CastlingMove(BoardManager newBM, int oldX, int oldY, int newX, int newY) {
		super(newBM, oldX, oldY, newX, newY);
	}

	@Override
	public void execute() {
		// TODO implement it
	}

	@Override
	public void undo() {
		// TODO implement it
	}
}
