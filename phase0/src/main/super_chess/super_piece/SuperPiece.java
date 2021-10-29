package super_chess.super_piece;

public abstract class SuperPiece implements SuperPieceInterface{
    int Hp;
    int Atk;

    @Override
    public int getSuperHp() {
        return this.Hp;
    }

    @Override
    public int getSuperAtk() {
        return this.Atk;
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
