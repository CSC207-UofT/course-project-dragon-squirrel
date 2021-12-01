package BoardManager;

import Board.*;
import Command.MoveRecord;
import Player.*;
import piece.*;

/**
 * It should receive some input from players and send command to a Board.Board instance
 * It should reflect the changes on the board and let players know
 */
public class BoardManager {

    // These are the variables we might need
    protected Board board;
    protected Player activePlayer;
    protected GameStatus status;
    protected MoveRecord MR;

    public BoardManager() {
        this.board = new Board(8, 8);
        this.MR = new MoveRecord();
        resetBoard();
    }

    public BoardManager(int column, int row) {
        this.board = new SuperBoard(column, row);
        this.MR = new MoveRecord();
        resetBoard();
    }

    public Board getBoard() {
        return this.board;
    }

    public String[][] getBoardAsString() {
        return board.to2dStringArray();
    }

    public MoveRecord getMR(){
        return MR;
    }

    public PieceInterface getPiece(int x, int y) {
        return board.getPiece(x, y);
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player player) {
        this.activePlayer = player;
    }

    public void movePiece(int oldX, int oldY, int newX, int newY) {
        // Calls board.addPiece() and board.removePiece()
        PieceInterface pieceToMove = board.removePiece(oldX, oldY);
        board.addPiece(pieceToMove, newX, newY);
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
        Piece[][] Piece2dArray = new Piece[8][8];

        // initialize white pieces
        Piece2dArray[7][0] = new Rook("rook_l", Color.WHITE);
        Piece2dArray[7][1] = new Knight("knight_l", Color.WHITE);
        Piece2dArray[7][2] = new Bishop("bishop_l", Color.WHITE);
        Piece2dArray[7][3] = new Queen("queen", Color.WHITE);
        Piece2dArray[7][4] = new King("king", Color.WHITE);
        Piece2dArray[7][5] = new Bishop("bishop_r", Color.WHITE);
        Piece2dArray[7][6] = new Knight("knight_r", Color.WHITE);
        Piece2dArray[7][7] = new Rook("rook_r", Color.WHITE);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[6][i] = new Pawn(name, Color.WHITE);
        }

        // initialize black pieces
        Piece2dArray[0][0] = new Rook("rook_l", Color.BLACK);
        Piece2dArray[0][1] = new Knight("knight_l", Color.BLACK);
        Piece2dArray[0][2] = new Bishop("bishop_l", Color.BLACK);
        Piece2dArray[0][3] = new Queen("queen", Color.BLACK);
        Piece2dArray[0][4] = new King("king", Color.BLACK);
        Piece2dArray[0][5] = new Bishop("bishop_r", Color.BLACK);
        Piece2dArray[0][6] = new Knight("knight_r", Color.BLACK);
        Piece2dArray[0][7] = new Rook("rook_r", Color.BLACK);

        for (int i = 0; i < 8; i++) {
            String name = "pawn_" + i;
            Piece2dArray[1][i] = new Pawn(name, Color.BLACK);
        }

        // initialize remaining board with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                Piece2dArray[i][j] = null;
            }
        }

        board.reset(Piece2dArray);
    }
}
