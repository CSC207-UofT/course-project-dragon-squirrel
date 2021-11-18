package CommandFuture;

import Board.*;
import piece.PieceInterface;
import piece.SuperPieceDecorator;

public class CaptureMove extends Move{

	protected final PieceInterface targetPiece;
	protected int hpDeduction;

	public CaptureMove(Board board, int oldX, int oldY, int newX, int newY) {
		super(board, oldX, oldY, newX, newY);
		targetPiece = board.getPiece(newX, newY);

		try {
			hpDeduction = ((SuperPieceDecorator) actionPiece).getAtk();
		} catch (ClassCastException e) {
			hpDeduction = 0;
		}
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
