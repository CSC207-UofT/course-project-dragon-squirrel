package piece;

import Board.Board;

import java.awt.*;
import java.util.List;

public class Pawn extends Piece{

    private boolean hasNotMovedDuringGame;

    public Pawn(String name, Color color){
        super(name, color);
        hasNotMovedDuringGame = true;
    }

    @Override
    public boolean validMove(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        boolean solution;
        if (color == Color.WHITE) {
            solution = ((newCoorX - oldCoorX == -1 && newCoorY - oldCoorY == 0));
        }
        else {
            solution = ((newCoorX - oldCoorX == 1 && newCoorY - oldCoorY == 0));
        }
        if (solution) {
            return true;
        }
        if (hasNotMovedDuringGame) {
            if (color == Color.WHITE) {
                solution = (newCoorX - oldCoorX == -2 && newCoorY - oldCoorY == 0);
            }
            else {
                solution = (newCoorX - oldCoorX == 2 && newCoorY - oldCoorY == 0);
            }
        }

        return solution;
    }

    @Override
    public List<Point> GetValidMoves(Board b, int x, int y) {
        return null;
    }
}
