package Board;

import piece.*;
import piece.Color;


import java.awt.Point;

/**
 * Entity
 */
public class Board implements BoardInterface{

    private PieceInterface[][] board;   // Each cell can be the name/ID of a piece
    Point boundaries;

    public Board(int column, int row) {
        board = new PieceInterface[column][row];
        this.boundaries = new Point(column, row);
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
        String[][] boardAsString = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                PieceInterface piece = board[i][j];
                String color = piece.isBlack() ? "b_" : "w_";
                String name = piece.getName();

                boardAsString[i][j] = color + name;
            }
        }
        return boardAsString;
    }
}
