package super_chess.super_piece;

public interface SuperPiece {
    String getSuperName();  // ex: "w_super_pawn_1"
    SuperColor getSuperColor(); // ex: WHITE
    boolean getSuperStatus();   // true -> piece has moved during the turn
    void setSuperStatus();
    boolean hasSuperSameColor();

    // new features
    int getSuperHp();
    int getSuperAtk();  // attack points
    boolean hasSuperMoved();    // can only move once per turn
    boolean hasSuperAttacked(); // can only attack once per turn
}
