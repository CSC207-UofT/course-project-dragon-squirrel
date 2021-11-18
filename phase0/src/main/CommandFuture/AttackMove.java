package CommandFuture;

import Board.Board;
import BoardManager.SuperBoardManager;

/**
 *
 *
 * IN PROGRESS
 *
 */
public class AttackMove extends Move{

	protected final String targetPiece;

	public AttackMove(Board board, int oldX, int oldY, int newX, int newY) {
		super(board, oldX, oldY, newX, newY);
		targetPiece = boardManager.getBoard().getPiece(newX, newY);
	}

	public String getTargetPiece(){
		return targetPiece;
	}

	@Override
	public void execute() {
		// TODO implement it
	}

	@Override
	public void undo() {
		((SuperBoardManager) boardManager).deductOrAddHp(oldPosition[0], oldPosition[1], newPosition[0], newPosition[1],
				false);
	}
}
