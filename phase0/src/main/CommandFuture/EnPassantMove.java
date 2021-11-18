package CommandFuture;

import BoardManager.BoardManager;

public class EnPassantMove extends Move{
	public EnPassantMove(BoardManager newBM, int oldX, int oldY, int newX, int newY) {
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
