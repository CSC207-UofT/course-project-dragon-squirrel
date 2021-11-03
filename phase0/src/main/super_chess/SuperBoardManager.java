package super_chess;

import super_chess.super_piece.SuperPieceInterface;

import java.util.Map;

public interface SuperBoardManager {
    SuperBoardInterface getSuperBoard();
    String[][] getSuperCurrentBoard();
    Map<String, SuperPieceInterface> getSuperPieces();
    SuperPlayer getSuperP1();
    SuperPlayer getSuperP2();
    SuperPlayer getSuperActivePlayer();
    void setSuperActivePlayer();
    void resetSuperMap();
    void moveSuperPiece();

    // new features
    void reducePieceHP();
}
