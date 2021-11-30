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
    private final boolean firstMove;
    private final MoveType moveType;

    /**
     * @param newBM BoardManager
     * @param oldX starting x coordinate of the action piece
     * @param oldY starting y coordinate of the action piece
     * @param newX target x coordinate
     * @param newY target y coordinate
     * @param firstMoveOfPieceDuringGame true if this is the first time the piece has moved during the game, false
     *                                   otherwise
     * @param typeOfMove REGULAR, CAPTURE, ATTACK, EN_PASSANT, CASTLING
     */
    public ChessMove(BoardManager newBM, int oldX, int oldY, int newX, int newY,
                     boolean firstMoveOfPieceDuringGame, MoveType typeOfMove){
        BM = newBM;
        oldPosition = new Point(oldX, oldY);
        newPosition = new Point(newX, newY);
        oldPiece = BM.getPiece(oldX, oldY);
        newPiece = BM.getPiece(newX, newY);
        firstMove = firstMoveOfPieceDuringGame;
        moveType = typeOfMove;

        if (typeOfMove == MoveType.EN_PASSANT) {
            otherPiece = BM.getPiece(oldX, newY);
        }
        else if (typeOfMove == MoveType.CASTLING) {
            otherPiece = BM.getPiece(newX, (newY == 6)? 7 : 0);
        } else {otherPiece = null;}
    }

    /**
     * @return the x coordinate of the action / moving piece
     */
    public int getOldX(){
        return oldPosition.x;
    }

    /**
     * @return the y coordinate of the action / moving piece
     */
    public int getOldY(){
        return oldPosition.y;
    }

    /**
     * @return the x coordinate of target location
     */
    public int getNewX(){
        return newPosition.x;
    }

    /**
     * @return the y coordinate of target location
     */
    public int getNewY(){
        return newPosition.y;
    }

    /**
     * @return the action / moving piece
     */
    public PieceInterface getOldPiece() {return oldPiece;}

    /**
     * @return the piece on the target coordinate if there is one.
     */
    public PieceInterface getNewPiece() {return newPiece;}

    /**
     * @return the implicated rook if moveType is Castling, captured pawn if moveType is EnPassant, and null otherwise.
     */
    public PieceInterface getOtherPiece() {return otherPiece;}

    /**
     * @return true if this is the first move of the piece during the game, false otherwise.
     */
    public boolean getFirstMoveStatus(){
        return firstMove;
    }

    /**
     * @return REGULAR, ATTACK, CAPTURE, CASTLING, EN_PASSANT
     */
    public MoveType getMoveType(){
        return moveType;
    }
}
