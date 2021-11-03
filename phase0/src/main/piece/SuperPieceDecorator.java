package piece;

public class SuperPieceDecorator extends PieceDecorator{
    int hp;
    int atk;

    public SuperPieceDecorator(Piece piece, int hp, int atk) {
        super(piece);
        this.hp = hp;
        this.atk = atk;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAtk() {
        return this.atk;
    }
}

// This is what we'd write in SuperBoardManager to instantiate the superPieces
// SuperPieceDecorator yay = new SuperPieceDecorator(new King("b_king", Color.BLACK), 10, 11);
//
