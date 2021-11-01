package command;

import Board.*;


public class Move implements Command{
    BoardManager BM;
    Board board;
    ChessRuleMove CRM;

    public Move(BoardManager newBM, ChessRuleMove newChessRule){
        this.BM = newBM;
        this.CRM = newChessRule;
    }

    @Override
    public void execute() {
        if (CRM.move()) {
            BM.getMR().add(CRM);
            board.movePiece(CRM.getOldCoordX(), CRM.getOldCoordY(), CRM.getNewCoordX(), CRM.getNewCoordY());
        }
    }

    @Override
    public void undo() {

    }
}
