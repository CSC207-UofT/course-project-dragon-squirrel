import java.util.ArrayList;

/**
 * Guess this is a use case class
 */
public class Board {
    private Player p1;
    private Player p2;
    private Piece[][] board;

    /**
     * Add a piece to the coordinate
     * @param pieceToAdd
     * @param X
     * @param Y
     */
    public void addPiece(Piece pieceToAdd, int X, int Y) {

    }

    /**
     * Remove a piece from the coordinate
     * addPiece() and removePiece() work together to move a piece within the board
     * @param X
     * @param Y
     */
    public void removePiece(int X, int Y) {

    }

    /**
     * This kicks in when a piece is being attacked
     * @param pieceToModify
     * @param HpDeduction
     */
    public void DeductPieceHp(Piece pieceToModify, int HpDeduction) {

    }

    /**
     * Switch player status between
     * @param p
     */
    public void switchPlayerStatus(Player p) {

    }

    /**
     * Switch piece status between 'moved' and 'movable'
     * This is useful if we are moving multiple pieces in a round
     * @param p
     */
    public void switchPieceStatus(Piece p) {

    }

//        /**
//     * piece1 attacks piece2, calculate result
//     * @param piece1
//     * @param piece2
//     * @param coorX     X coordinate of the piece being attacked
//     * @param coorY     Y coordinate of the piece being attacked
//     *
//     * The params and implementation will likely change in the future
//     */
//    private void attackPiece(Piece piece1, Piece piece2, int coorX, int coorY) {
//
//    }
}
