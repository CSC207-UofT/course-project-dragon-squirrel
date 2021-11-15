package piece;

import Board.Board;

import java.awt.*;
import java.util.List;

public class Queen extends Piece{

    public Queen(String name, Color color){
        super(name, color);
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        return Math.abs(oldCoorX - newCoorX) == Math.abs(oldCoorY - newCoorY) || (Math.abs(oldCoorX - newCoorX) == 0 || Math.abs(oldCoorY - newCoorY) == 0);
    }

    @Override
    public List<Point> GetValidMoves(Board b, int x, int y) {
        return null;
    }
}
