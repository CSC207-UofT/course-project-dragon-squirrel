package command;

import Board.*;

public class BishopRule implements ChessRuleMove {
    BoardManager bm;
    Board board;
    BasicMoveCheck moveCheck;
    int[] positionOld = new int[2];
    int[] positionNew = new int[2];

    public BishopRule(BoardManager bm, Board board, int oldX, int oldY, int newX, int newY){
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

        return Math.abs(positionOld[0] - positionNew[0]) == Math.abs(positionOld[1] - positionNew[1]);
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
