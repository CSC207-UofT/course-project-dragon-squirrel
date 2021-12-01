package chessAI;

import BoardManager.BoardManager;

import java.awt.Point;

/**
 * IN PROGRESS
 *
 * Minimax is a more comprehensive adversarial searching algorithm, it can look several steps forward and choose the
 * best move (assuming the opponent will always choose the best move)
 *
 * this is hard
 */
public class Minimax extends Engine{

	private int maxDepth;

	public Minimax(BoardManager bm, int depth) {
		super(bm);
		maxDepth = depth;
	}

	@Override
	public Point[] makeDecision() {
		return null;    // TODO
	}

	public int search(int depth) {

		if (depth == 0) {
			return currentState.getScore();
		}

		while (!searchingQueue.isEmpty()) {
			currentState = searchingQueue.remove();
			int score = search(depth - 1);

			if (currentState.getPlayer() == startingState.getPlayer() && score > bestScore) {
				bestScore = score;
				bestState = currentState;
			} else if (currentState.getPlayer() != startingState.getPlayer() && score < worstScore) {
				bestScore = score;
				bestState = currentState;
			}
		}

		return 0;   // TODO
	}
}
