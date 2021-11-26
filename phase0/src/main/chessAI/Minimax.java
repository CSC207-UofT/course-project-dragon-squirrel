package chessAI;

import BoardManager.BoardManager;

import java.awt.*;

/**
 * IN PROGRESS
 *
 * Minimax is a more comprehensive adversarial searching algorithm, it can look several steps forward and choose the
 * best move (assuming the opponent will always choose the best move)
 *
 * this is hard
 */
public class Minimax extends Engine{

	public Minimax(BoardManager bm) {
		super(bm);

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
