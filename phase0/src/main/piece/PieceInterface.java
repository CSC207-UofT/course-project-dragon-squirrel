package piece;

import java.awt.Point;
import java.util.List;

import Board.BoardInterface;


public interface PieceInterface {
    int PAWN_VALUE = 100;
    int KNIGHT_VALUE = 300;
    int BISHOP_VALUE = 300;
    int ROOK_VALUE = 500;
    int QUEEN_VALUE = 900;
    int KING_VALUE = 99999;

    String getName();
    Color getColor();
    int getValue();
    boolean isBlack();
    boolean isWhite();
    boolean getStatus();
    void setStatus(boolean status);
    boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY);
    Piece deepCopy();
    boolean hasSameColor(PieceInterface targetPiece);
    List<Point> getValidMoves(BoardInterface b, int x, int y);

}
