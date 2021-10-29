package super_chess.super_piece;

public abstract class SuperPiece implements SuperPieceInterface{

    @Override
    public int getSuperHp() {
        return 0;
    }

    @Override
    public int getSuperAtk() {
        return 0;
    }

    @Override
    public boolean hasSuperMoved() {
        return false;
    }

    @Override
    public boolean hasSuperAttacked() {
        return false;
    }
}
