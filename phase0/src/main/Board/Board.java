package Board;

import piece.*;

import java.awt.Point;

/**
 * Entity
 */
public class Board implements BoardInterface{

    protected PieceInterface[][] board;
    protected Point boundaries;

    public Board(int column, int row) {
        board = new PieceInterface[column][row];
        boundaries = new Point(column, row);
    }

    /**
     * @return board with 2d array of piece in corresponding positions
     */
    public PieceInterface[][] getBoard() {
        return board;
    }

    /**
     * @return Point (column, row) boundaries of the board
     */
    public Point getBoundaries() {return boundaries;}

    /**
     * Place piece at board[X][Y]
     */
    public void addPiece(PieceInterface piece, int X, int Y) {
        board[X][Y] = piece;
    }

    /**
     * Remove piece from board[X][Y] and replace with null
     */
    public PieceInterface removePiece(int X, int Y) {
        PieceInterface piece = board[X][Y];
        board[X][Y] = null;
        return piece;
    }

    /**
     * @return true if position at board[X][Y] is vacant (does not have a piece), false otherwise
     */
    public boolean isPositionVacant(int X, int Y) {
        return board[X][Y] == null;
    }

    /**
     * @return the piece at board[X][Y], or null if there is no piece.
     */
    public PieceInterface getPiece(int X, int Y) {
        return board[X][Y];
    }

    /**
     * Set board attribute in Board class as the board argument given.
     */
    public void reset(PieceInterface[][] board)
    {
        this.board = board;
    }

    /**
     * Stored strings are piece names ("b_pawn", "w_rook", etc.) or "vacant"
     * @return 2d string array of board.
     */
    public String[][] to2dStringArray(int x, int y) {
        String[][] boardAsString = new String[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    PieceInterface piece = board[i][j];
                    String color = piece.isBlack() ? "b_" : "w_";
                    String name = piece.getName();

                    boardAsString[i][j] = color + name;
                }
                catch (NullPointerException e){
                    boardAsString[i][j] = "vacant";
                }
            }
        }
        return boardAsString;
    }

    // TODO need to test it actually works, hopefully it does
    public Board deepCopy() {
        if (board == null) {
            return null;
        }

        // Deep copy the 2d array
        PieceInterface[][] piece2dArray = new PieceInterface[boundaries.x][boundaries.y];

        for (int i = 0; i < boundaries.x; i++) {
            for (int j = 0; j < boundaries.y; j++) {
                piece2dArray[i][j] = board[i][j].deepCopy();    //TODO requires Piece.deepCopy() work properly
            }
        }

        // Put 2d array copy into new board
        Board boardCopy = new Board(boundaries.x, boundaries.y);
        boardCopy.board = piece2dArray;

        return boardCopy;
    }
}
