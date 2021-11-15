package piece;

import Board.Board;

import java.awt.*;
import java.util.List;

public class King extends Piece{

    public King(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) <= 1 && Math.abs(oldCoorY - newCoorY) <= 1;

        //TODO: what if we are castling
    }

    @Override
    public List<Point> GetValidMoves(Board b, int x, int y) {
        return null;
    }
}
