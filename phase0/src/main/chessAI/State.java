package chessAI;

import Board.Board;
import Command.Move;

import java.util.ArrayList;

public class State {

	private State prev;
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

	public ArrayList<State> generateNextState() {
		return null;
	}

	private void calculateScore() {
		// TODO
	}
}
