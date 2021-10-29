package super_chess.super_piece;

import piece.Color;
import piece.PieceInterface;

public class SuperPieceAdapter extends SuperPiece implements SuperPieceInterface {

    PieceInterface piece;

    public SuperPieceAdapter(PieceInterface piece){
        this.piece = piece;
    }

    @Override
    public String getSuperName() {
        return this.piece.getName();
    }

    @Override
    public Color getSuperColor() {
        return this.piece.getColor();
    }

    @Override
    public boolean getSuperStatus() {
        return this.piece.getStatus();
    }

    @Override
    public void setSuperStatus(boolean status) {
        this.piece.setStatus(status);
    }

//    @Override
//    public boolean hasSuperSameColor(Piece another) {
//        return this.piece.hasSameColor(another);
//    }

//    @Override
//    public int getSuperHp() {
//        return 0;
//    }
//
//    @Override
//    public int getSuperAtk() {
//        return 0;
//    }
//
//    @Override
//    public boolean hasSuperMoved() {
//        return false;
//    }
//
//    @Override
//    public boolean hasSuperAttacked() {
//        return false;
//    }
}
