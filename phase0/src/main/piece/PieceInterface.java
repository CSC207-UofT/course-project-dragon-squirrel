package piece;

import java.awt.Point;
import java.util.List;

import Board.Board;


public interface PieceInterface {
    String getName();
    Color getColor();
    boolean getStatus();
    void setStatus(boolean status);
    boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);
    boolean hasSameColor(PieceInterface targetPiece);
    List<Point> GetValidMoves(Board b, int x, int y);

}
