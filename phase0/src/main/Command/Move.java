package Command;

import BoardManager.BoardManager;
import piece.King;
import piece.Pawn;
import piece.PieceInterface;
import piece.Rook;

public abstract class Move implements Command{
    protected BoardManager BM;
    protected ChessMove CM;
    protected PieceInterface actionPiece;
    protected PieceInterface targetPiece;

    public Move(BoardManager newBM){
        this.BM = newBM;
    }

    public Move(BoardManager newBM, ChessMove newChessRule){
        this.BM = newBM;
        this.CM = newChessRule;
        this.actionPiece = newChessRule.getOldPiece();
        this.targetPiece = newChessRule.getNewPiece();
    }

    @Override
    public void execute() {
        if (actionPiece instanceof Pawn)
            ((Pawn) actionPiece).hasNotMovedDuringGame = false;
        // TODO also do it for King and Rook
    }
    
    @Override
    public abstract void undo();
}
