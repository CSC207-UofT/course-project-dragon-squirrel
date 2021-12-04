package GameRule;

import Board.Board;
import Command.ChessMove;
import Command.MoveRecord;
import Command.MoveType;
import piece.*;
import piece.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Verifies whether move is valid according to game rules.
 */
public class GameRule {

	private final Board board;
	private final MoveRecord MR;

	public GameRule(Board board, MoveRecord MR) {
		this.board = board;
		this.MR = MR;
	}

	public Board getBoard(){return board;}

	/**
	 * Check whether move is valid according to classic chess game rules
	 * @return type of move (INVALID, EN_PASSANT, CASTLING, CAPTURE, REGULAR)
	 */
	public MoveType isMoveValid(int oldX, int oldY, int newX, int newY) {

		if (!isCoordinateValid(oldX, oldY, newX , newY)) {
			return MoveType.INVALID;
		}
		if (enPassant(oldX, oldY, newX, newY)){
			return MoveType.EN_PASSANT;
		}
		if (pawnCapture(oldX, oldY, newX, newY)){
			return MoveType.CAPTURE;
		}
		if (Castling(oldX, oldY, newX, newY)) {
			return MoveType.CASTLING;
		}
		PieceInterface actionPiece = board.getPiece(oldX, oldY);
		PieceInterface targetPiece = board.getPiece(newX, newY);

		if (actionPiece == null) {
			System.out.println("Piece not found");
			return MoveType.INVALID;
		}
		if (targetPiece != null && actionPiece.hasSameColor(targetPiece)) {
			System.out.println("Invalid capture");
			return MoveType.INVALID;
		}
		if (!actionPiece.validMove(oldX, oldY, newX , newY)) {
			System.out.println("Invalid Move");
			return MoveType.INVALID;
		}
		if (!(actionPiece.getName().contains("knight")) && !isPathClear(oldX, oldY, newX , newY)) {
			System.out.println("Path not clear");
			System.out.println(actionPiece.getName());
			return MoveType.INVALID;
		}

		if (MR.isEmpty()){
			try {
				if (board.getPiece(oldX,oldY).isBlack()){
					return MoveType.INVALID;
				}
			}catch (NullPointerException e){
				return MoveType.INVALID;
			}
		}else {
			try {
				if (MR.get().getOldPiece().hasSameColor(board.getPiece(oldX, oldY))){
					return MoveType.INVALID;
				}
			}catch (NullPointerException e){
				return MoveType.INVALID;
			}
		}

		if (targetPiece != null && !actionPiece.hasSameColor(targetPiece)) {
			return MoveType.CAPTURE;
		}

		return MoveType.REGULAR;
	}

	/**
	 * Check: old and new coordinates are not same and that
	 *        new coordinate is within the board
	 */
	public boolean isCoordinateValid(int oldX, int oldY, int newX, int newY) {
		int xBoundary = board.getBoundaries().x;
		int yBoundary = board.getBoundaries().y;
		return newX >= 0 && newX < xBoundary && newY >= 0 && newY < yBoundary && (oldX != newX || oldY != newY);
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
	 * Does not add coordinates old and new to the list.
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
	 * Check if the current player wins
	 */
	public boolean isPlayerWinning() {
		return false;
	}

	/**
	 * Get the next available moves of a piece
	 * This is VERY important if we want an AI player make thoughtful decisions (involves decision tree etc.)
	 *
	 * @param p The position of the piece
	 * @return  An array of coordinates, each is a valid position to move
	 */
	public List<Point> getAvailableMoves(Point p) {
		return board.getBoard()[p.x][p.y].getValidMoves(board, p.x, p.y);
	}

	/**
	 * @return true if enPassant is applicable, false otherwise
	 */
	public boolean enPassant(int oldX, int oldY, int newX, int newY){
		if (MR.isEmpty()){
			return false;
		}
		ChessMove lastMove = MR.get();
		PieceInterface lastMovePiece = lastMove.getOldPiece();
		PieceInterface movingPiece = board.getPiece(oldX, oldY);
		if (!(movingPiece instanceof Pawn)){
			return false;
		}
		if (!(lastMovePiece instanceof Pawn)){
			return false;
		}
		if (Math.abs(lastMove.getNewX() - lastMove.getOldX()) != 2){
			return false;
		}
		if (Math.abs(lastMove.getNewY() - oldY) != 1 || lastMove.getNewX() != oldX){
			return false;
		}
		if (lastMovePiece.hasSameColor(movingPiece)){
			return false;
		}
		if (movingPiece.getColor().equals(piece.Color.WHITE)){
			return newX == oldX - 1 && newY == lastMove.getNewY();
		}
		else return newX == oldX + 1 && newY == lastMove.getNewY();
	}

	/**
	 * @return true if a pawnCapture is applicable, false otherwise
	 */
	public boolean pawnCapture(int oldX, int oldY, int newX, int newY){
		PieceInterface movingPiece = board.getPiece(oldX, oldY);
		PieceInterface capturedPiece = board.getPiece(newX, newY);
		if (!(board.getPiece(oldX, oldY) instanceof Pawn)){
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

	/**
	 *
	 * @param X coordinate X of detected point
	 * @param Y coordinate Y of detected point
	 * @param color the player will be attacked.
	 * @return true if Point(x,y) can be attacked by player controlling different colored pieces
	 */
	public boolean isAttackedStatus(int X, int Y, Color color){
		ArrayList<Point> opponentPiece;
		if (color.equals(Color.WHITE)){
			opponentPiece = (ArrayList<Point>) board.getAllPiece(Color.BLACK);
		}
		else {opponentPiece = (ArrayList<Point>) board.getAllPiece(Color.WHITE);}
		for (Point piece:opponentPiece){
			Point newPoint = new Point(X, Y);
			if (board.getPiece(piece.x, piece.y).getValidMoves(board, piece.x, piece.y).contains(newPoint)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Check: 	Moving King and implicated rook has not moved during the game.
	 * 			King either moves two squares to the right or two to the left.
	 * 			Path is clear between the king and the rook.
	 * 			The current king position and king's path is not under checkmate.
	 * @return true if Castling is applicable, false otherwise
	 */
	public boolean Castling(int oldX, int oldY, int newX, int newY) {
		PieceInterface movingPiece = board.getPiece(oldX, oldY);
		PieceInterface capturedPiece = board.getPiece(newX, newY);
		PieceInterface rook = board.getPiece(newX, (newY == 6) ? 7 : 0);
		if (!(movingPiece instanceof King)) {
			return false;
		}
		if (((King) movingPiece).getHasMovedDuringGame()) {
			return false;
		}
		if (capturedPiece != null) {
			return false;
		}
		if (!((oldX == 0 && newX == 0 && (newY == 2 || newY == 6)) ||
				(oldX == 7 && newX == 7 && (newY == 2 || newY == 6)))) {
			return false;
		}
		if (!isPathClear(oldX, oldY, newX, (newY == 6) ? 7 : 0)) {
			return false;
		}
		if (((Rook) rook).getHasMovedDuringGame()) {
			return false;
		}

		ArrayList<Point> passingLocation = new ArrayList<>();
		int start = Math.min(oldY, newY);
		int end = Math.max(oldY, newY);
		for (int i = start; i <= end; i++){
			Point passingLoc = new Point();
			passingLoc.x = oldX;
			passingLoc.y = i;
			passingLocation.add(passingLoc);
		}
		for (Point location: passingLocation){
			if (isAttackedStatus(location.x, location.y, movingPiece.getColor())){
				return false;
			}
		} // check that the king does not pass through a square that is attacked by an enemy piece.

		return true;
	}
}
