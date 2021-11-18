package CommandFuture;

import Board.Board;
import BoardManager.SuperBoardManager;
import piece.PieceInterface;
import piece.SuperPieceDecorator;

/**
 *
 *
 * IN PROGRESS
 *
 */
public class AttackMove extends Move{

	protected final PieceInterface targetPiece;
	protected int hpDeduction;

	public AttackMove(Board board, int oldX, int oldY, int newX, int newY) {
		super(board, oldX, oldY, newX, newY);
		targetPiece = board.getPiece(newX, newY);
		hpDeduction = ((SuperPieceDecorator) actionPiece).getAtk();
	}

	public PieceInterface getTargetPiece(){
		return targetPiece;
	}

	@Override
	public void execute() {
		((SuperPieceDecorator) targetPiece).modifyHp(-hpDeduction);
	}

	@Override
	public void undo() {
		((SuperPieceDecorator) targetPiece).modifyHp(hpDeduction);
	}
}
