package chessAI;

import BoardManager.BoardManager;

import java.awt.Point;
import java.util.List;

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

	/**
	 * Minimax searching algorithm
	 * @param depth The searching depth, this heavily affects machine performance
	 * @param curr  The current state
	 * @param maxi  whether we are maxi of mini
	 * @return  The highest/lowest score of this state
	 */
	public int search(int depth, State curr, boolean maxi) {

		if (depth == 0) {
			return curr.getScore();
		}

		List<State> nextStates = curr.generateNextState();

		if (maxi) {     // Maxi time, return the highest score among next states
			State bestState = null;

			for (State state: nextStates) {
				int currScore = search(depth - 1, state, false);

				if (bestState == null || currScore > bestState.getScore()) {
					bestState = state;
					super.bestState = state;
				}
			}

			assert bestState != null;
			return bestState.getScore();
		}
		else {      // Mini time, return the lowest score among next states
			State worstState = null;

			for (State state: nextStates) {
				int currScore = search(depth - 1, state, true);

				if (worstState == null || currScore < worstState.getScore()) {
					worstState = state;
				}
			}

			assert worstState != null;
			return worstState.getScore();
		}
	}
}
