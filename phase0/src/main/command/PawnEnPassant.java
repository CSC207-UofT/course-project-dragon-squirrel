package command;

import Board.*;
import piece.*;

public class PawnEnPassant implements ChessRuleMove {
    BoardManager bm;
    Board board;
    BasicMoveCheck moveCheck;
    int[] positionOld = new int[2];
    int[] positionNew = new int[2];

    public PawnEnPassant(BoardManager bm, Board board, int oldX, int oldY, int newX, int newY){
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
        Pawn piece = (Pawn) bm.getCorrespondPiece(positionOld[0], positionOld[1]);
        ChessRuleMove lastMove = bm.getMR().get();
        if (lastMove instanceof PawnTwoSquareMove &&
                (Math.abs(lastMove.getNewCoordY() - positionOld[1]) == 1 &&
                        lastMove.getNewCoordX() == positionOld[0])){
            if (piece.getColor().equals(Color.WHITE)){
                return positionNew[0] == positionOld[0] - 1 && positionNew[1] == lastMove.getNewCoordY();
            }
            else return positionNew[0] == positionOld[0] + 1 && positionNew[1] == lastMove.getNewCoordY();
        }
        else return false;

        // check basic rules.
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
