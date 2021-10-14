import piece.Piece;
import java.util.Map;

/**
 * This contains one set of game rules.
 * Since the game has two sets of rule, we can easily make subclass of it to describe the second rule
 */
public class GameRule {

	private Board board;
	private Map<String, Piece> piecesDict;   // key: ID, value: Piece

	public GameRule() {
		// Initialize variables so they are the same objects in BoardManager
	}

	public boolean isMoveValid(int oldX, int oldY, int newX, int newY) {
		if (!isCoordinateValid(oldX, oldY, newX , newY))
			return false;

		String pieceName = board.getPiece(oldX, oldY);
		String targetPieceName = board.getPiece(newX, newY);
		Piece pieceToMove = piecesDict.get(pieceName);
		Piece targetPiece = targetPieceName == null ? null : piecesDict.get(targetPieceName);

		if (pieceToMove == null)
			return false;

		if (targetPiece != null && pieceToMove.hasSameColor(targetPiece))
			return false;

		if (!pieceToMove.validMove(oldX, oldY, newX , newY))
			return false;

		// There is probably more rule checking
		// Maybe call isPathClear() and isCoordinateVacant()
		// GameRule doesn't modify actual board/pieces here

		return true;
	}

	/**
	 * It might be a good idea to separate clearValidPath() into two methods
	 */
	public boolean isPathClear(int oldX, int oldY, int newX, int newY) {
		return false;
	}

	/**
	 * It might be a good idea to separate clearValidPath() into two methods
	 */
	public boolean isCoordinateVacant(int X, int Y) {
		return false;
	}

	/**
	 * Check: old and new coordinates are not same
	 *        new coordinate is within the board
	 */
	private boolean isCoordinateValid(int oldX, int oldY, int newX, int newY) {
		return newX >= 0 & newX < 8 & newY >= 0 & newY < 8 & (oldX != newX || oldY != newY);
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
	 * This is VERY important if we want an AI player make thoughtful decisions (involves decision tree etc.)
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
