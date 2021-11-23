package chessAI;

import Board.Board;
import piece.Color;
import piece.PieceInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This only works in classical piece yet
 */
public class State {

	private State prev;
	private Board board;
	private Color activePlayer;
	private int score;

	public State(Board board, State prev) {
		this.board = board;
		this.prev = prev;
		activePlayer = (prev.activePlayer == Color.WHITE ? Color.BLACK : Color.WHITE);
		evaluateScore();
	}

	public int getScore() {
		return score;
	}

	public Color getPlayer() {
		return activePlayer;
	}

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

					nextStates.add(new State(boardCopy, this));
				}
			}
		}

		return nextStates;
	}



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
