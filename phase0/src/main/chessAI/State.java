package chessAI;

import Board.Board;
import Command.Move;

public class State {

	private Board board;
	private int score;
	private int depth;

	public State(Board board) {
		this.board = board;
		calculateScore();
	}

	public int getScore() {
		return score;
	}

	public State[] generateNextState(Move move) {

	}

	private void calculateScore() {
		// TODO
	}
}
