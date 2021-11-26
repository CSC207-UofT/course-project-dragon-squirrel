package chessAI;

import Board.Board;
import piece.Color;
import piece.PieceInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A state containing all information of the game at a specific time.
 * Usually we need to search through a tree of states to make a wise move.
 *
 * This only works in classical piece yet
 */
public class State {

	private final Board board;
	private final Color activePlayer;
	private int score;
	private final Point[] prevMove;

	public State(Board board, Color prevPlayer, Point[] prevMove) {

		this.board = board;
		this.prevMove = prevMove;
		activePlayer = (prevPlayer == Color.WHITE ? Color.BLACK : Color.WHITE);
		evaluateScore();
	}

	public int getScore() {
		return score;
	}

	public Color getPlayer() {
		return activePlayer;
	}

	public Point[] getPrevMove() {
		return prevMove;
	}

	/**
	 * Apply all available moves to current state to generate all possible next states.
	 * Used to explore the state tree and search through.
	 *
	 * @return  A list containing all possible next states by moving 1 step
	 */
	public List<State> generateNextState() {

		List<State> nextStates = new ArrayList<>();

		int col = board.getBoundaries().x;
		int row = board.getBoundaries().y;

		// Loop through board
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				PieceInterface piece = board.getPiece(i, j);
				List<Point> validPositionsToMove = new ArrayList<>();

				if (piece != null && piece.getColor() == activePlayer) {
					validPositionsToMove = piece.getValidMoves(board, i, j);
				}

				// Generate new board copy and apply move for each position
				for (Point p: validPositionsToMove) {
					Board boardCopy = board.deepCopy();
					PieceInterface actionPiece = boardCopy.removePiece(i, j);
					boardCopy.addPiece(actionPiece, p.x, p.y);

					Point[] prevMove = new Point[2];
					prevMove[0] = new Point(i, j);
					prevMove[1] = new Point(p.x, p.y);

					nextStates.add(new State(boardCopy, activePlayer, prevMove));
				}
			}
		}

		return nextStates;
	}

	/**
	 * Evaluate this state and give a score. Higher the better.
	 */
	private void evaluateScore() {
		int col = board.getBoundaries().x;
		int row = board.getBoundaries().y;

		// Loop through board
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {

				PieceInterface piece = board.getPiece(i, j);

				if (piece != null) {
					// Player's piece add score, opponent's piece deduct score
					int pieceValue = piece.getValue();
					score += piece.getColor() == activePlayer ? pieceValue : -pieceValue;
				}

			}
		}
	}
}
