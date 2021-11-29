package Command;

import BoardManager.BoardManager;
import piece.PieceInterface;

import java.awt.*;

public class ChessMove {
    private final Point oldPosition;
    private final Point newPosition;
    private BoardManager BM;
    private final PieceInterface oldPiece;
    private final PieceInterface newPiece;
    private final PieceInterface otherPiece;
    private final MoveType moveType;

    public ChessMove(BoardManager newBM, int oldX, int oldY, int newX, int newY, MoveType typeOfMove){
        BM = newBM;
        oldPosition = new Point(oldX, oldY);
        newPosition = new Point(newX, newY);
        oldPiece = BM.getPiece(oldX, oldY);
        newPiece = BM.getPiece(newX, newY);
        moveType = typeOfMove;

        if (typeOfMove == MoveType.ENPASSANT) {
            otherPiece = BM.getPiece(oldX, newY);
        }
        else{otherPiece = null;}
    }

    public int getOldX(){
        return oldPosition.x;
    }

    public int getOldY(){
        return oldPosition.y;
    }

    public int getNewX(){
        return newPosition.x;
    }

    public int getNewY(){
        return newPosition.y;
    }

    public PieceInterface getOldPiece() {return oldPiece;}

    public PieceInterface getNewPiece() {return newPiece;}

    public PieceInterface getOtherPiece() {return otherPiece;}

    /**
     * @return REGULAR, ATTACK, CAPTURE, CASTLING, ENPASSANT
     */
    public MoveType getMoveType(){
        return moveType;
    }

    public BoardManager getBM(){
        return this.BM;
    }

}
