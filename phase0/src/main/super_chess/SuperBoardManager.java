package super_chess;

import piece.PieceDecorator;

import java.util.Map;

public interface SuperBoardManager {
    SuperBoardInterface getSuperBoard();
    String[][] getSuperCurrentBoard();
    Map<String, PieceDecorator> getSuperPieces();
    SuperPlayer getSuperP1();
    SuperPlayer getSuperP2();
    SuperPlayer getSuperActivePlayer();
    void setSuperActivePlayer();
    void resetSuperMap();
    void moveSuperPiece();

    // new features
    void reducePieceHP();
}
