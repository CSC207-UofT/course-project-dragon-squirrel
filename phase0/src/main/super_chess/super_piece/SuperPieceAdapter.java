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

    // (start comment) confused why both need to be defined
    @Override
    public boolean hasSuperSameColor(SuperPieceInterface another) {
        return this.piece.hasSameColor((PieceInterface) another);
    }

    @Override
    public boolean hasSuperSameColor(PieceInterface another) {
        return this.piece.hasSameColor(another);
    }
    // (end comment)

}
