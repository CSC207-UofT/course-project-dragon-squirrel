package chessAI;

import BoardManager.BoardManager;
import piece.PieceInterface;

import java.awt.Point;
import java.util.PriorityQueue;

/**
 * Minimax is a more comprehensive adversarial searching algorithm, it can look several steps forward and choose the
 * best move (assuming the opponent will always choose the best move)
 */
public class Minimax extends Engine{

	private final int POS_INF = PieceInterface.KING_VALUE * 10;
	private final int NEG_INF = -PieceInterface.KING_VALUE * 10;
	private final int maxDepth;

	public Minimax(BoardManager bm, int depth) {
		super(bm);
		maxDepth = depth;
	}

	@Override
	public Point[] makeDecision() {
		bestState = null;
		minimaxSearch(maxDepth, startingState, true, NEG_INF, POS_INF);
		return bestState.getPrevMove();
	}

	/**
	 * Minimax searching algorithm with Alpha Beta pruning
	 * @param depth The searching depth, this heavily affects machine performance
	 * @param curr  The current state
	 * @param maxi  whether we are maxi of mini
	 * @return  The highest/lowest score of this state
	 */
	private int minimaxSearch(int depth, State curr, boolean maxi, int alpha, int beta) {
		PriorityQueue<State> nextStates = new PriorityQueue<>((o1, o2) -> o2.getScore() - o1.getScore());

		if (depth == 0 || curr.isGameOver()) {
			return curr.getScore();
		}

		nextStates.addAll(curr.generateNextState());

		if (maxi) {     // AI's turn, maximizing score, return the highest score among next states
			State bestState = null;
			int bestScore = NEG_INF;

			for (State state: nextStates) {
				int currScore = minimaxSearch(depth - 1, state, false, alpha, beta);
				if (currScore > bestScore) {
					bestState = state;
					bestScore = currScore;
				}

				alpha = Math.max(alpha, currScore);
				if (beta <= alpha)
					break;
			}

			// This is the initial call of minimax search, the best state of this call is AI's decision
			if (depth == maxDepth)
				super.bestState = bestState;

			return bestScore;
		}
		else {      // Player's turn, minimizing score, return the lowest score among next states
			int worstScore = POS_INF;

			for (State state: nextStates) {
				int currScore = minimaxSearch(depth - 1, state, true, alpha, beta);
				if (currScore < worstScore)
					worstScore = currScore;

				beta = Math.min(beta, currScore);
				if (beta <= alpha)
					break;
			}

			return worstScore;
		}
	}
}
