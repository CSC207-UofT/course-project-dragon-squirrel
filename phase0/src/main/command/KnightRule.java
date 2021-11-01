package command;

import Board.*;

public class KnightRule implements ChessRuleMove {
    BoardManager bm;
    Board board;
    BasicMoveCheck moveCheck;
    int[] positionOld = new int[2];
    int[] positionNew = new int[2];

    public KnightRule(BoardManager bm, Board board, int oldX, int oldY, int newX, int newY){
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
        if (moveCheck.isColorSame(positionOld[0], positionOld[1], positionNew[0], positionNew[1])){
            return false;
        }
        // check color same.

        if (moveCheck.checkBoundAndMove(positionOld[0], positionOld[1], positionNew[0], positionNew[1])){
            return false;
        }
        // check bound and whether move.

        int X = Math.abs(positionOld[0] - positionNew[0]);
        int Y = Math.abs(positionOld[1] - positionNew[1]);
        return (X == 2 && Y == 1) || (X == 1 && Y == 2);
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
