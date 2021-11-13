package Command;

import BoardManager.*;


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
        if (CM.getMoveType() > 1) {
            BM.movePiece(CM.getOldCoordX(), CM.getOldCoordY(), CM.getNewCoordX(), CM.getNewCoordY());
        }
    }

    @Override
    public void undo() {
        ChessMove lastMove = BM.getMR().get();
        BM.getMR().remove();

        // move is an attack: add back health points
        if (lastMove.getMoveType() == 1){
            ((SuperBoardManager) BM).deductOrAddHp(lastMove.getOldCoordX(), lastMove.getOldCoordY(),
                    lastMove.getNewCoordX(), lastMove.getNewCoordY(), false);
        } // move is a move: put pieces back in place
        else {
            BM.movePiece(lastMove.getNewCoordX(), lastMove.getNewCoordY(), lastMove.getOldCoordX(), lastMove.getOldCoordY());
            BM.getBoard().addPiece(lastMove.getNewPieceName(), lastMove.getNewCoordX(), lastMove.getNewCoordY());
        } // move is a move after a successful attack: put pieces back in place and add back health points
        if (lastMove.getMoveType() == 3) {
            ((SuperBoardManager) BM).deductOrAddHp(lastMove.getOldCoordX(), lastMove.getOldCoordY(),
                    lastMove.getNewCoordX(), lastMove.getNewCoordY(), false);
        }
    }
}