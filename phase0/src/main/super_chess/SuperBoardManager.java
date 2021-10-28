package super_chess;

import super_chess.super_piece.SuperPiece;

import java.util.Map;

public interface SuperBoardManager {
    SuperBoard getSuperBoard();
    String[][] getSuperCurrentBoard();
    Map<String, SuperPiece> getSuperPieces();
    SuperPlayer getSuperP1();
    SuperPlayer getSuperP2();
    SuperPlayer getSuperActivePlayer();
    void setSuperActivePlayer();
    void resetSuperMap();
    void moveSuperPiece();

    // new features
    void reducePieceHP();
}
