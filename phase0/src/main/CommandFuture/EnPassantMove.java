package CommandFuture;

import Board.Board;

/**
 *
 *
 * PLACEHOLDER
 *
 * we might or might not need it
 * we probably need
 *
 */
public class EnPassantMove extends Move{
	public EnPassantMove(Board board, int oldX, int oldY, int newX, int newY) {
		super(board, oldX, oldY, newX, newY);
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
