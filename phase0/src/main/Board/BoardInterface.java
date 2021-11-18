package Board;

import java.awt.Point;

/**
 * The only purpose of this interface is to get rid of the dependency between Piece and Board
 *
 * This is only a temporary solution
 */
public interface BoardInterface {
	Point getBoundaries();
	boolean isPositionVacant(int X, int Y);
	String getPiece(int X, int Y);
}
