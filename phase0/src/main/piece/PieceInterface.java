package piece;

import java.awt.Point;
import java.util.List;

import Board.BoardInterface;


public interface PieceInterface {
    String getName();
    Color getColor();
    boolean getStatus();
    void setStatus(boolean status);
    boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);
    boolean hasSameColor(PieceInterface targetPiece);
    List<Point> getValidMoves(BoardInterface b, int x, int y);

}
