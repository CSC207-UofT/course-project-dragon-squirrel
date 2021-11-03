import board.Board;
import piece.Piece;
import java.util.Map;

/**
 * This contains one set of game rules.
 * Since the game has two sets of rule, we can easily make subclass of it to describe the second rule
 */
public class GameRule {

	private Board board;
	private Map<String, Piece> piecesDict;   // key: ID, value: Piece

	public GameRule(Board board, Map<String, Piece> piecesDict) {
		this.board = board;
		this.piecesDict = piecesDict;
	}

	public boolean isMoveValid(int oldX, int oldY, int newX, int newY) {

		if (!isCoordinateValid(oldX, oldY, newX , newY)) {
			System.out.println("Coordinate invalid");
			return false;
		}

		String pieceName = board.getPiece(oldX, oldY);
		String targetPieceName = board.getPiece(newX, newY);
		Piece pieceToMove = piecesDict.get(pieceName);
		Piece targetPiece = targetPieceName == "vacant" ? null : piecesDict.get(targetPieceName);

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

		// There is probably more rule checking
		// Maybe call isPathClear() and isCoordinateVacant()
		// GameRule doesn't modify actual board/pieces here

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
	private boolean isCoordinateValid(int oldX, int oldY, int newX, int newY) {
		return newX >= 0 & newX < 8 & newY >= 0 & newY < 8 & (oldX != newX || oldY != newY);
	}

	/**
	 * Check: path between old and new coordinates is clear of pieces
	 * 		  does not check coordinates old and new themselves
	 */
	public boolean isPathClear(int oldX, int oldY, int newX, int newY) {
		if (oldY == newY) {
			// vertical north and south
			for (int i = Math.min(oldX, newX) + 1; i < Math.max(oldX, newX); i++) {
				if (!board.isPositionVacant(i, newY))
					return false;
			}
		}

		if (oldX == newX) {
			// horizontal east and west
			for (int i = Math.min(oldY, newY) + 1; i < Math.max(oldY, newY); i++) {
				if (!board.isPositionVacant(newX, i))
					return false;
			}
		}

		if ((oldX < newX & oldY < newY) || (oldX > newX & oldY > newY)) {
			// diagonal northwest or southeast
			for (int i = 1; i < Math.abs(newX - oldX); i++) {
				if (!board.isPositionVacant(Math.min(oldX, newX) + i, Math.min(oldY, newY) + i))
					return false;
			}
		}

		if ((oldX > newX & oldY < newY) || (oldX < newX & oldY > newY)) {
			// diagonal northeast or southwest
			for (int i = Math.abs(newX - oldX) - 1; i > 0; i--) {
				if (!board.isPositionVacant(Math.max(oldX, newX) - i, Math.min(oldY, newY) + i))
					return false;
			}
		}

		return true;
	}

	/**
	 * It might be a good idea to separate clearValidPath() into two methods
	 * this seems like the same thing as isPositionVacant() in board
	 */
	public boolean isCoordinateVacant(int X, int Y) {
		return false;
	}

	/**
	 * The only pieces interaction scenario I can think of is that one attacks another
	 * Let's design some game rules together! (maybe after this phase)
	 */
	public void piecesInteraction(Piece attacker, Piece defender) {
		// Maybe use board.DeductPieceHp()
	}

	/**
	 * Check if the current player wins
	 * @return
	 */
	public boolean isPlayerWinning() {
		return false;
	}

	/**
	 * Get the next available moves of a piece
	 * This is VERY important if we want an player.AI player make thoughtful decisions (involves decision tree etc.)
	 * We don't need to worry about it now
	 *
	 * @param p The piece that moves (we want to know which kind of piece it is)
	 * @param X Current X coordinate
	 * @param Y Current Y coordinate
	 * @return  An array of coordinates, each is a valid position to move
	 */
	public int[][] getAvailableMoves(Piece p, int X, int Y) {
		return null;
	}
}
