package command;

import Board.*;
import piece.Color;
import piece.Pawn;
import piece.Piece;

public class PawnTwoSquareMove implements ChessRuleMove {
    BoardManager bm;
    Board board;
    BasicMoveCheck moveCheck;
    int[] positionOld = new int[2];
    int[] positionNew = new int[2];

    public PawnTwoSquareMove(BoardManager bm, Board board, int oldX, int oldY, int newX, int newY){
        this.bm = bm;
        this.board = board;
        positionOld[0] = oldX;
        positionOld[1] = oldY;
        positionNew[0] = newX;
        positionNew[1] = newY;
        this.moveCheck = new BasicMoveCheck(board, bm);
    }

    @Override
    public boolean move() {
        if (moveCheck.basicCheck(positionOld[0], positionOld[1], positionNew[0], positionNew[1])){
            return false;
        }
        // check basic rules.

        Pawn piece = (Pawn) bm.getCorrespondPiece(positionOld[0], positionOld[1]);
        boolean solution;
        if (piece.getMoved()) {
            if (piece.getColor() == Color.WHITE) {
                solution = (positionNew[0] - positionOld[0] == -2 && positionNew[1] - positionOld[1] == 0);
            }
            else {
                solution = (positionNew[0] - positionOld[0] == 2 && positionNew[1] - positionOld[1] == 0);
            }
        }
        else solution = false;
        if (solution) {
            piece.setMoved();
            return true;
        }
        else return false;
        // check piece rules.
    }

    @Override
    public int getOldCoordX() {
        return positionOld[0];
    }

    @Override
    public int getNewCoordX() {
        return positionNew[0];
    }

    @Override
    public int getOldCoordY() {
        return positionOld[1];
    }

    @Override
    public int getNewCoordY() {
        return positionNew[1];
    }

}
