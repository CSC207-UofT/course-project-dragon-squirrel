package chessAI;

import BoardManager.BoardManager;
import piece.PieceInterface;
import java.util.LinkedList;
import java.util.Queue;

public class Engine {
	private State startingState;
	private State bestState;
	private Queue<State> searchStates = new LinkedList<>();
	State currentState;

	private int bestScore = -PieceInterface.KING_VALUE;
	private int worstScore = PieceInterface.KING_VALUE;

	public Engine(BoardManager bm) {

		// TODO initialize states
		startingState = new State(bm.getBoard(), null);

	}

	public int search(int depth) {

		if (depth == 0) {
			return currentState.getScore();
		}

		while (!searchStates.isEmpty()) {
			currentState = searchStates.remove();
			int score = search(depth - 1);


			if (currentState.getPlayer() == startingState.getPlayer() && score > bestScore) {
				bestScore = score;
				bestState = currentState;
			} else if (currentState.getPlayer() != startingState.getPlayer() && score < worstScore) {
				bestScore = score;
				bestState = currentState;
			}
		}

		return 0;   //TODO
	}
}
