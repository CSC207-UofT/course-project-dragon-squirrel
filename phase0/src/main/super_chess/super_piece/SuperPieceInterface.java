package super_chess.super_piece;

import piece.Color;

public interface SuperPieceInterface {
    String getSuperName();  // ex: "w_super_pawn_1"
    Color getSuperColor(); // ex: WHITE
    boolean getSuperStatus();   // true -> piece has moved during the turn
    void setSuperStatus(boolean status);
//    boolean hasSuperSameColor(SuperPiece another);    // tricky

    // new features
    int getSuperHp();
    int getSuperAtk();  // attack points
    boolean hasSuperMoved();    // can only move once per turn
    boolean hasSuperAttacked(); // can only attack once per turn
}
