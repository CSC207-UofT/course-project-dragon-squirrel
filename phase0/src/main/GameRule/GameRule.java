package GameRule;

import Board.Board;
import Command.ChessMove;
import Command.MoveRecord;
import piece.Color;
import piece.PieceInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * This contains one set of game rules.
 * Since the game has two sets of rule, we can easily make subclass of it to describe the second rule
 */
public class GameRule {

	private Board board;
	private Map<String, PieceInterface> piecesDict;   // key: ID, value: Piece
	private MoveRecord MR;

	public GameRule(Board board, Map<String, PieceInterface> piecesDict, MoveRecord MR) {
		this.board = board;
		this.piecesDict = piecesDict;
		this.MR = MR;
	}

	public Board getBoard(){return board;}

	public Map<String, PieceInterface> getPiecesDict(){return piecesDict;}

	/**
	 * @return whether move is valid according to classic chess game rules
	 */
	public boolean isMoveValid(int oldX, int oldY, int newX, int newY) {

		if (!isCoordinateValid(oldX, oldY, newX , newY)) {
			System.out.println("Coordinate invalid");
			return false;
		}

		if (enPassant(oldX, oldY, newX, newY)){
			return true;
		}

		if (pawnCapture(oldX, oldY, newX, newY)){
			return true;
		}

		String pieceName = board.getPiece(oldX, oldY);
		String targetPieceName = board.getPiece(newX, newY);
		PieceInterface pieceToMove = piecesDict.get(pieceName);
		PieceInterface targetPiece = targetPieceName.equals("vacant") ? null : piecesDict.get(targetPieceName);

		if (pieceToMove == null) {
			System.out.println("Piece not found");
			return false;
		}

		if (targetPiece != null && pieceToMove.hasSameColor(targetPiece)) {
			System.out.println("Invalid capture");
			return false;
		}

		if (!pieceToMove.validMove(oldX, oldY, newX , newY)) {
			System.out.println("Invalid Move");
			return false;
		}

		if (!pieceName.contains("knight") && !isPathClear(oldX, oldY, newX , newY)) {
			System.out.println("Path not clear");
			return false;
		}

		return true;
	}

	/**
	 * Check: old and new coordinates are not same
	 *        new coordinate is within the board
	 */
	public boolean isCoordinateValid(int oldX, int oldY, int newX, int newY) {
		int xBoundary = board.getBoundaries().x;
		int yBoundary = board.getBoundaries().y;
		return newX >= 0 & newX < xBoundary + 1 & newY >= 0 & newY < yBoundary + 1 & (oldX != newX || oldY != newY);
	}

	/**
	 * Does not check coordinates old and new themselves
	 * @return whether path between (oldX, oldY) and (newX, newY) is clear of pieces
	 */
	public boolean isPathClear(int oldX, int oldY, int newX, int newY){
		ArrayList<Point> coordinates = pathCoordinates(oldX, oldY, newX, newY);
		for (Point point: coordinates) {
			if (!board.isPositionVacant(point.x, point.y)){
				return false;
			}
		}
		return true;
	}

	/**
	 * @return a list of the coordinates in the path between (oldX, oldY) and (newX, newY)
	 */
	public ArrayList<Point> pathCoordinates(int oldX, int oldY, int newX, int newY) {
		ArrayList<Point> coordinates = new ArrayList<>();

		if (oldY == newY) {
			// vertical north and south
			for (int i = Math.min(oldX, newX) + 1; i < Math.max(oldX, newX); i++) {
				coordinates.add(new Point(i, newY));
			}
		}

		else if (oldX == newX) {
			// horizontal east and west
			for (int i = Math.min(oldY, newY) + 1; i < Math.max(oldY, newY); i++) {
				coordinates.add(new Point(newX, i));
			}
		}

		else if ((oldX < newX & oldY < newY) || (oldX > newX & oldY > newY)) {
			// diagonal northwest or southeast
			for (int i = 1; i < Math.abs(newX - oldX); i++) {
				coordinates.add(new Point(Math.min(oldX, newX) + i, Math.min(oldY, newY) + i));
			}
		}

		else {
			// diagonal northeast or southwest
			for (int i = Math.abs(newX - oldX) - 1; i > 0; i--) {
				coordinates.add(new Point(Math.max(oldX, newX) - i, Math.min(oldY, newY) + i));
			}
		}

		return coordinates;
	}

	public boolean isCoordinateVacant(int X, int Y) {
		return false;
	}

	/**
	 * The only pieces interaction scenario I can think of is that one attacks another
	 * Let's design some game rules together! (maybe after this phase)
	 */
	public void piecesInteraction(PieceInterface attacker, PieceInterface defender) {
		// Maybe use board.DeductPieceHp()
	}

	/**
	 * Check if the current player wins
	 */
	public boolean isPlayerWinning() {
		return false;
	}

	/**
	 * Get the next available moves of a piece
	 * This is VERY important if we want an Player.AI player make thoughtful decisions (involves decision tree etc.)
	 * We don't need to worry about it now
	 *
	 * @param p The piece that moves (we want to know which kind of piece it is)
	 * @param X Current X coordinate
	 * @param Y Current Y coordinate
	 * @return  An array of coordinates, each is a valid position to move
	 */
	public int[][] getAvailableMoves(PieceInterface p, int X, int Y) {
		return null;
	}

	public boolean enPassant(int oldX, int oldY, int newX, int newY){
		if (MR.isEmpty()){
			return false;
		}
		ChessMove lastMove = MR.get();
		PieceInterface lastMovePiece = piecesDict.get(lastMove.getOldPieceName());
		PieceInterface movingPiece = piecesDict.get(board.getPiece(oldX, oldY));
		if (!board.getPiece(oldX, oldY).contains("pawn")){
			return false;
		}
		if (!lastMove.getOldPieceName().contains("pawn")){
			return false;
		}
		if (Math.abs(lastMove.getNewCoordX() - lastMove.getOldCoordX()) != 2){
			return false;
		}
		if (Math.abs(lastMove.getNewCoordY() - oldY) != 1 || lastMove.getNewCoordX() != oldX){
			return false;
		}
		if (lastMovePiece.hasSameColor(movingPiece)){
			return false;
		}
		if (movingPiece.getColor().equals(piece.Color.WHITE)){
			return newX == oldX - 1 && newY == lastMove.getNewCoordY();
		}
		else return newX == oldX + 1 && newY == lastMove.getNewCoordY();
	}

	public boolean pawnCapture(int oldX, int oldY, int newX, int newY){
		PieceInterface movingPiece = piecesDict.get(board.getPiece(oldX, oldY));
		PieceInterface capturedPiece = piecesDict.get(board.getPiece(newX, newY));
		if (!board.getPiece(oldX, oldY).contains("pawn")){
			return false;
		}
		if (capturedPiece == null){
			return false;
		}
		if (capturedPiece.hasSameColor(movingPiece)){
			return false;
		}
		if (movingPiece.getColor().equals(Color.WHITE)){
			return (newX - oldX == -1 && Math.abs(newY - oldY) == 1);
		}
		else return (newX - oldX == 1 && Math.abs(newY - oldY) == 1);

	}
}
