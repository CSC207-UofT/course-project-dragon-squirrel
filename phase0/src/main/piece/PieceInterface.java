package piece;

import java.awt.Point;
import java.util.List;

import Board.Board;
import Board.BoardInterface;

public interface PieceInterface {
    int PAWN_VALUE = 100;
    int KNIGHT_VALUE = 300;
    int BISHOP_VALUE = 300;
    int ROOK_VALUE = 500;
    int QUEEN_VALUE = 900;
    int KING_VALUE = 99999;


    Color getColor();
    boolean isBlack();
    boolean isWhite();
    String getName();
    boolean getStatus();
    void setStatus(boolean status);
    int getValue();
    boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);
    boolean hasSameColor(PieceInterface targetPiece);
    List<Point> getValidMoves(BoardInterface b, int x, int y);
    PieceInterface deepCopy();
    boolean withinBoundary(int x, int y, BoardInterface b);
    boolean isOpponentPiece(int x, int y, BoardInterface b);
    
}
