import java.util.ArrayList;

/**
 * Guess this is a use case class
 */
public class Board {
//    private Player p1;
//    private Player p2;


    private Piece[][] board;

    private Player activePlayer;

    public Board() {
        // .....
    }

    public Piece getPiece(int X, int Y) {
        return null;
    }

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
     * @return  The piece been removed
     */
    public Piece removePiece(int X, int Y) {
        return null;
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
     */
    public void switchActivePlayer() {

    }

    /**
     * Switch piece status between 'moved' and 'movable'
     * This is useful if we are moving multiple pieces in a round
     * @param p
     */
    public void switchPieceStatus(Piece p) {

    }

    /**
     * Return 0 if the path is clear but the new coordinate is occupied with an opponent's piece
     * Return 1 if the path is clear and the new coordinate is vacant
     * Return 2 if the path is not clear
     * Return 3 if the path is not clear but the new coordinate is vacant (for knight)
     * Return -1 if there is some error
     */
    public int clearValidPath(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {
        //uses the validMove() method in Piece
        return -1;
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
