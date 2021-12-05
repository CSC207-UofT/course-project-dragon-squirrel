package Board;

import piece.*;


import java.awt.Point;

/**
 * Entity
 */
public class Board implements BoardInterface{

    protected PieceInterface[][] board;   // Each cell can be the name/ID of a piece
    protected Point boundaries;

    public Board(int column, int row) {
        board = new PieceInterface[column][row];
        boundaries = new Point(column, row);
    }

    public PieceInterface[][] getBoard() {
        return board;
    }

    public Point getBoundaries() {return boundaries;}

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

    public boolean isPositionVacant(int X, int Y) {
        return board[X][Y] == null;
    }

    public PieceInterface getPiece(int X, int Y) {
        return board[X][Y];
    }

    public void reset(PieceInterface[][] board)
    {
        this.board = board;
    }

    public String[][] to2dStringArray() {
        String[][] boardAsString = new String[boundaries.x][boundaries.y];

        for (int i = 0; i < boundaries.x; i++) {
            for (int j = 0; j < boundaries.y; j++) {
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
                if (board[i][j] != null)
                    piece2dArray[i][j] = board[i][j].deepCopy();
                else
                    piece2dArray[i][j] = null;
            }
        }

        // Put 2d array copy into new board
        Board boardCopy = new Board(boundaries.x, boundaries.y);
        boardCopy.board = piece2dArray;

        return boardCopy;
    }
}
