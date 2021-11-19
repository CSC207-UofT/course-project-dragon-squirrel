package Board;

import piece.PieceInterface;

import java.awt.Point;

/**
 * The only purpose of this interface is to get rid of the dependency between Piece and Board
 */
public interface BoardInterface {
	Point getBoundaries();
	boolean isPositionVacant(int X, int Y);
	PieceInterface getPiece(int X, int Y);
}
