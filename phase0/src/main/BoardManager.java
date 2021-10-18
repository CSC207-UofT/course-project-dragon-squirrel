import piece.*;

import java.util.HashMap;
import java.util.Map;

/**
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
    private Player activePlayer;
    private GameStatus status;

    public BoardManager() {
        this.board = new Board();
        this.pieces = new HashMap<>();
        resetMap();
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

    public Player getP1() {
        return this.p1;
    }

    public Player getP2() {
        return this.p2;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player player) {
        this.activePlayer = player;
    }

    public void resetMap() {
        // initialize white pieces and put into Map
        pieces.put("w_rook_l", new Rook("w_rook_l", Color.WHITE));
        pieces.put("w_knight_l", new Knight("w_knight_l", Color.WHITE));
        pieces.put("w_bishop_l", new Bishop("w_bishop_l", Color.WHITE));
        pieces.put("w_queen", new Queen("w_queen", Color.WHITE));
        pieces.put("w_king", new King("w_king", Color.WHITE));
        pieces.put("w_bishop_r", new Bishop("w_bishop_r", Color.WHITE));
        pieces.put("w_knight_r", new Knight("w_knight_r", Color.WHITE));
        pieces.put("w_rook_r", new Rook("w_rook_r", Color.WHITE));

        for (int i = 0; i < 8; i++) {
            String name = "w_pawn_" + i;
            pieces.put(name, new Pawn(name, Color.WHITE));
        }

        // initialize black pieces and put into Map
        pieces.put("b_rook_l", new Rook("b_rook_l", Color.BLACK));
        pieces.put("b_knight_l", new Knight("b_knight_l", Color.BLACK));
        pieces.put("b_bishop_l", new Bishop("b_bishop_l", Color.BLACK));
        pieces.put("b_queen", new Queen("b_queen", Color.BLACK));
        pieces.put("b_king", new King("b_king", Color.BLACK));
        pieces.put("b_bishop_r", new Bishop("b_bishop_r", Color.BLACK));
        pieces.put("b_knight_r", new Knight("b_knight_r", Color.BLACK));
        pieces.put("b_rook_r", new Rook("b_rook_r", Color.BLACK));

        for (int i = 0; i < 8; i++) {
            String name = "b_pawn_" + i;
            pieces.put(name, new Pawn(name, Color.BLACK));
        }
    }

    public void movePiece(int oldX, int oldY, int newX, int newY) {
        // Calls board.addPiece() and board.removePiece()
        String pieceToMove = board.removePiece(oldX, oldY);
        board.addPiece(pieceToMove, newX, newY);
    }

    /**
     * This kicks in when a piece is being attacked
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
     */
    public void switchPieceStatus(Piece p) {

    }

    public void resetBoard() {
        board.reset();
        // Also reset the pieces somehow
    }
}
