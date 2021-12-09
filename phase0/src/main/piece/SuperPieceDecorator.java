package piece;

import java.awt.Point;
import java.util.List;
import Board.BoardInterface;

public class SuperPieceDecorator extends PieceDecorator{
    int hp;
    int atk;
    public boolean hasNotMoved;
    boolean hasNotAttacked;

    public SuperPieceDecorator(Piece piece, int hp, int atk) {
        super(piece);
        this.hp = hp;
        this.atk = atk;
        this.hasNotMoved = true;
        this.hasNotAttacked = true;
    }

    /**
     * @return the hp of the super piece
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * @return attack level of the super piece
     */
    public int getAtk() {
        return this.atk;
    }

    /**
     * @return true if piece has not moved, false if it has.
     */
    public boolean getHasNotMoved() {
        return this.hasNotMoved;
     }

    /**
     * @return true if piece has not attacked, false if it has.
     */
    public boolean getHasNotAttacked() {
        return this.hasNotAttacked;
     }

    /**
     * Set hp of piece as hp.
     */
    public void setHp(int hp) {this.hp = hp;}

    /**
     * Modify hp by adding value to the current hp.
     */
    public void modifyHp(int value) {
        hp += value;
    }

    /**
     * @return a List of the valid points the pawn can move to given piece behaviour, game rules, and
     * present board state.
     */
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