package Board;

import piece.*;


import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity
 */
public class Board implements BoardInterface, Serializable {

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

    public Point findKing(Color color) {
        Point position = null;
        for (int i = 0; i < boundaries.x; i++) {
            for (int j = 0; j < boundaries.y; j++) {
                if (board[i][j] instanceof King && board[i][j].getColor() == color)
                    position = new Point(i, j);
            }
        }

        return position;
    }

    /**
     * Reset/overwrite the board with the given 2d array
     * This method should be invoked by BoardManager
     */
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

    /**
     *
     * @param color piece color
     * @return all position of piece with same color.
     */
    public List<Point> getAllPiece(Color color){
        ArrayList<Point> solution = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for (int j =0; j < board[0].length; j++){
                try {
                    PieceInterface piece = getPiece(i, j);
                    Point piecePosition = new Point();
                    piecePosition.x = i;
                    piecePosition.y = j;
                    if (piece.getColor().equals(color)){
                        solution.add(piecePosition);
                    }
                }
                catch (NullPointerException ignored){
                }
            }
        }
        return solution;
    }

    public void setPiece(int x, int y, PieceInterface piece){
        board[x][y] = piece;
    }
}
