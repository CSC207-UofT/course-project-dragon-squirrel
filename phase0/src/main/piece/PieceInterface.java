package piece;

import java.awt.Point;
import java.util.List;

import Board.Board;
import Board.BoardInterface;


public interface PieceInterface {
    String getName();
    Color getColor();
    boolean isBlack();
    boolean isWhite();
    boolean getStatus();
    void setStatus(boolean status);
    boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);
    boolean hasSameColor(PieceInterface targetPiece);
    List<Point> getValidMoves(BoardInterface b, int x, int y);
    public boolean withinBoundary(int x, int y, BoardInterface b);
    public boolean isOpponentPiece(int x, int y, BoardInterface b);
    
}
