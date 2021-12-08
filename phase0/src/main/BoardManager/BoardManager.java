package BoardManager;

import Board.*;
import Chesstimer.ChessTimer;
import Command.MoveRecord;
import piece.*;
import piece.Color;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * It should receive some input from players and send command to a Board.Board instance
 * It should reflect the changes on the board and let players know
 */
public class BoardManager implements Serializable {

    protected Board board;
    protected Color activePlayer;
    protected GameStatus status;
    protected MoveRecord MR;
    protected ChessTimer timer;

    public BoardManager() {
        this.board = new Board(8, 8);
        this.MR = new MoveRecord();
        resetBoard();
        timer = new ChessTimer();
        activePlayer = Color.WHITE;
        timer.startWhiteTimer();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BoardManager(int x, int y, PieceInterface piece){
        this();
        board.setPiece(x,y,piece);
    }

    public BoardManager(int column, int row) {
        this.board = new SuperBoard(column, row);
        this.MR = new MoveRecord();
        resetBoard();
        timer = new ChessTimer();
        activePlayer = Color.WHITE;
        timer.startWhiteTimer();
    }

    /**
     * @return Board
     */
    public Board getBoard() {
        return this.board;
    }

    public ChessTimer getTimer(){
        return timer;
    }

    /**
     * Stored strings are piece names ("b_pawn", "w_rook", etc.) or "vacant"
     * @return 2d string array of board
     */
    public String[][] getBoardAsString() {
        return board.to2dStringArray();
    }

    /**
     * @return MoveRecord
     */
    public MoveRecord getMR(){
        return MR;
    }

    /**
     * @return the piece at board[X][Y], or null if there is no piece.
     */
    public PieceInterface getPiece(int x, int y) {
        return board.getPiece(x, y);
    }

    /**
     * @return true if piece (Pawn, Rook, or King) has moved during game, false if piece has not moved or if
     * piece is not an instance of the aforementioned piece types.
     */
    public boolean getHasMovedStatus(PieceInterface p) {
        if (p instanceof Pawn){
            return !((Pawn) p).getHasNotMovedDuringGame();
        }
        if (p instanceof Rook){
            return ((Rook) p).getHasMovedDuringGame();
        }
        if (p instanceof King){
            return ((King) p).getHasMovedDuringGame();
        }
        return false;
    }

    /**
     * Move piece from board[oldX][oldY] to board[newX][newY] by removing piece from its old coordinate in board and
     * adding it to the new coordinate in board.
     */
    public void movePiece(int oldX, int oldY, int newX, int newY) {
        // Calls board.addPiece() and board.removePiece()
        PieceInterface pieceToMove = board.removePiece(oldX, oldY);
        board.addPiece(pieceToMove, newX, newY);
    }

    /**
     * Switch player status between
     */
    public void switchActivePlayer() {
        if (activePlayer.equals(Color.WHITE)){
            activePlayer = Color.BLACK;
        }else {
            activePlayer = Color.WHITE;
        }
    }

    /**
     * Switch piece status between 'moved' and 'movable'
     * This is useful if we are moving multiple pieces in a round
     */
    public void switchPieceStatus(Piece p) {

    }

    /**
     * Switch piece's (Pawn, King, and Rook) status hasMovedDuringGame or hasNotMovedDuringGame to true or false
     * depending on parameter hasMoved.
     */
    public void switchPieceHasMovedStatus(PieceInterface p, boolean hasMoved) {
        if (p instanceof Pawn){
            ((Pawn) p).setHasNotMovedDuringGame(!hasMoved);
        }
        if (p instanceof King) {
            ((King) p).setHasMovedDuringGame(hasMoved);
        }
        if (p instanceof Rook){
            ((Rook) p).setHasMovedDuringGame(hasMoved);
        }
    }

    /**
     * Instantiate the pieces and add them to their corresponding starting positions in the board (2d piece interface
     * array) attribute held by Board.
     */
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

    /**
     * Switch timer at the end of every round.
     */
    public void switchChessTimer(){
        timer.switchTimer();
    }

    /**
     * check whether both king still stay at board. if not, change the game status. specifically, if white king lose,
     * black player win; if black king lose, white player win.
     */
    public void gameStatus(){
        boolean blackFlag = false;
        boolean whiteFlag = false;
        ArrayList<PieceInterface> blackPiece = new ArrayList<>();
        ArrayList<PieceInterface> whitePiece = new ArrayList<>();
        ArrayList<Point> blackPiecePosition = (ArrayList<Point>) board.getAllPiece(Color.BLACK);
        ArrayList<Point> whitePiecePosition = (ArrayList<Point>) board.getAllPiece(Color.WHITE);
        for (Point loc: blackPiecePosition){
            PieceInterface piece = board.getPiece(loc.x, loc.y);
            blackPiece.add(piece);
        }
        for (Point loc: whitePiecePosition){
            PieceInterface piece = board.getPiece(loc.x, loc.y);
            whitePiece.add(piece);
        }
        for (PieceInterface piece: blackPiece){
            if (piece instanceof King) {
                blackFlag = true;
                break;
            }
        }
        if (!blackFlag){
            status = GameStatus.WHITE_WIN;
        }
        for (PieceInterface piece: whitePiece){
            if (piece instanceof King) {
                whiteFlag = true;
                break;
            }
        }
        if (!whiteFlag){
            status = GameStatus.BLACK_WIN;
        }
    }
}
