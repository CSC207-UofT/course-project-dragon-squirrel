package piece;

import java.awt.Point;
import java.util.List;
import Board.BoardInterface;

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

    public void modifyHp(int value) {
        hp += value;
    }

    @Override
    public List<Point> getValidMoves(BoardInterface b, int x, int y) {
        return super.getValidMoves(b, x, y);
    }

    @Override
    public SuperPieceDecorator deepCopy() {
        SuperPieceDecorator newPiece = new SuperPieceDecorator(piece, hp, atk);
        newPiece.hasNotMoved = this.hasNotMoved;
        newPiece.hasNotAttacked = this.hasNotAttacked;
        return newPiece;
    }
}

// This is what we'd write in SuperBoardManager to instantiate the superPieces
// SuperPieceDecorator yay = new SuperPieceDecorator(new King("b_king", Color.BLACK), 10, 11);
//
