package command;

import board.*;


public class Move implements Command{
    BoardManager BM;
    ChessMove CM;

    public Move(BoardManager newBM){
        this.BM = newBM;
    }

    public Move(BoardManager newBM, ChessMove newChessRule){
        this.BM = newBM;
        this.CM = newChessRule;
    }

    @Override
    public void execute() {
            BM.getMR().add(CM);
            BM.movePiece(CM.getOldCoordX(), CM.getOldCoordY(), CM.getNewCoordX(), CM.getNewCoordY());
    }

    @Override
    public void undo() {
        ChessMove lastMove = BM.getMR().get();
        BM.getMR().remove();
        BM.movePiece(lastMove.getNewCoordX(), lastMove.getNewCoordY(), lastMove.getOldCoordX(), lastMove.getOldCoordY());
        BM.getBoard().addPiece(lastMove.getNewPieceName(), lastMove.getNewCoordX(), lastMove.getNewCoordY());

    }
}
