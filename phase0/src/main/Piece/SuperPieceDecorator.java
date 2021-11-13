package Piece;

public class SuperPieceDecorator extends PieceDecorator{
    int hp;
    int atk;
    boolean hasNotMoved;
    boolean hasNotAttacked;

    public SuperPieceDecorator(Piece piece, int hp, int atk) {
        super(piece);
        this.hp = hp;
        this.atk = atk;
        this.hasNotMoved = true;
        this.hasNotAttacked = true;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public boolean getHasNotMoved() {
        return this.hasNotMoved;
     }

    public boolean getHasNotAttacked() {
        return this.hasNotAttacked;
     }

    public void setHp(int hp) {this.hp = hp;}

}

// This is what we'd write in SuperBoardManager to instantiate the superPieces
// SuperPieceDecorator yay = new SuperPieceDecorator(new King("b_king", Color.BLACK), 10, 11);
//
