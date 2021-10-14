import piece.Piece;
import java.util.HashMap;
import java.util.Map;

/**
 * This should be in the controller/presenter layer
 * It should receive some input from players and send command to a Board instance
 * It should reflect the changes on the board and let players know
 * Perhaps we can separate controller and presenter to 2 classes
 *
 * Not sure how to design this part yet
 */
public class BoardManager {

    // These are the variables we might need
    private Board board;
    private Map<String, Piece> pieces;   // This is essentially dict in python with key: ID, value: Piece
    private Player p1;
    private Player p2;
    private Player activePlayer;
    private GameStatus status;

    public BoardManager() {
        this.board = new Board();
        this.pieces = new HashMap<>();


    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void movePiece(int oldX, int oldY, int newX, int newY) {
        // Calls addPiece() and removePiece()
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
}
