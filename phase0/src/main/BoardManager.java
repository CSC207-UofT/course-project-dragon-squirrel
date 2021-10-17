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

    public Board getBoard() {
        return board;
    }

    public String[][] getCurrentBoard() {
        return board.getBoard();
    }

    public Map<String, Piece> getPieces() {
        return pieces;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player player){
        this.activePlayer = player;
    }

    public void movePiece(int oldX, int oldY, int newX, int newY) {
        // Calls board.addPiece() and board.removePiece()
        String pieceToMove = board.removePiece(oldX, oldY);
        board.addPiece(pieceToMove, newX, newY);
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

    public void resetBoard() {
        board.reset();
        // Also reset the pieces somehow
    }
}
