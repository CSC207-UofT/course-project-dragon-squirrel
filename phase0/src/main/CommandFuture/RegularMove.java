package CommandFuture;

import Board.Board;

public class RegularMove extends Move{
	public RegularMove(Board board, int oldX, int oldY, int newX, int newY) {
		super(board, oldX, oldY, newX, newY);
	}

	@Override
	public void execute() {
		board.addPiece(actionPiece, newPosition.x, newPosition.y);
		board.removePiece(oldPosition.x, oldPosition.y);
	}

	@Override
	public void undo() {
		board.addPiece(actionPiece, oldPosition.x, oldPosition.y);
		board.removePiece(newPosition.x, newPosition.y);
	}
}
