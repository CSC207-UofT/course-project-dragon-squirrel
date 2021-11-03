package super_chess.super_piece;

import piece.Color;
import piece.PieceInterface;

public class SuperPieceAdapter extends SuperPiece implements SuperPieceInterface {

    PieceInterface superPiece;

    public SuperPieceAdapter(PieceInterface superPiece){
        this.superPiece = superPiece;
    }

    @Override
    public String getSuperName() {
        return this.superPiece.getName();
    }

    @Override
    public Color getSuperColor() {
        return this.superPiece.getColor();
    }

    @Override
    public boolean getSuperStatus() {
        return this.superPiece.getStatus();
    }

    @Override
    public void setSuperStatus(boolean status) {
        this.superPiece.setStatus(status);
    }

    // (start comment) confused why both need to be defined
    @Override
    public boolean hasSuperSameColor(SuperPieceInterface another) {
        return this.superPiece.hasSameColor((PieceInterface) another);
    }


}
