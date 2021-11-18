package CommandFuture;

import Board.*;
import piece.PieceInterface;
import piece.SuperPieceDecorator;

/**
 *
 *
 * IN PROGRESS
 *
 */
public class CaptureMove extends Move{

	protected final PieceInterface targetPiece;
	protected int hpDeduction;

	public CaptureMove(Board board, int oldX, int oldY, int newX, int newY) {
		super(board, oldX, oldY, newX, newY);
		targetPiece = board.getPiece(newX, newY);

		// TODO calculate hpDeduction somehow
	}

	public PieceInterface getTargetPiece(){
		return targetPiece;
	}

	@Override
	public void execute() {
		board.addPiece(actionPiece, newPosition.x, newPosition.y);
		board.removePiece(oldPosition.x, oldPosition.y);

		if (hpDeduction != 0) {
			((SuperPieceDecorator) targetPiece).modifyHp(-hpDeduction);
		}
	}

	@Override
	public void undo() {
		// Add piece back
		board.addPiece(actionPiece, oldPosition.x, oldPosition.y);
		board.addPiece(targetPiece, newPosition.x, newPosition.y);

		if (hpDeduction != 0) {
			((SuperPieceDecorator) targetPiece).modifyHp(hpDeduction);
		}
	}

}
