package TestController;

import BoardManager.BoardManager;
import Controller.BoardUpdater;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestBoardUpdater {

    int col;
    int row;
    Point boundaries;
    String[][] boardImage;
    BoardManager bm;
    BoardUpdater bu;

    @Before
    public void before(){
        col = 8;
        row = 8;
        boundaries = new Point(col, row);
        boardImage = new String[8][8];
        bm = new BoardManager();
        bu = new BoardUpdater(bm);
    }

    @Test(timeout = 50)
    public void TestgetBoardImageAsUnicode(){
        boardImage = bm.getBoardAsString();

        String[][] unicodeArray = new String[boundaries.x][boundaries.y];

        for (int i = 0; i < boundaries.x; i++) {
            for (int j = 0; j < boundaries.y; j++) {
                String piece = boardImage[i][j];
                String pieceUnicode = "";

                if (piece.contains("w_")) {
                    if (piece.contains("king"))
                        pieceUnicode = "\u2654";
                    if (piece.contains("queen"))
                        pieceUnicode = "\u2655";
                    if (piece.contains("rook"))
                        pieceUnicode = "\u2656";
                    if (piece.contains("bishop"))
                        pieceUnicode = "\u2657";
                    if (piece.contains("knight"))
                        pieceUnicode = "\u2658";
                    if (piece.contains("pawn"))
                        pieceUnicode = "\u2659";
                } else if (piece.contains("b_")) {
                    if (piece.contains("king"))
                        pieceUnicode = "\u265A";
                    if (piece.contains("queen"))
                        pieceUnicode = "\u265B";
                    if (piece.contains("rook"))
                        pieceUnicode = "\u265C";
                    if (piece.contains("bishop"))
                        pieceUnicode = "\u265D";
                    if (piece.contains("knight"))
                        pieceUnicode = "\u265E";
                    if (piece.contains("pawn"))
                        pieceUnicode = "\u265F";
                } else
                    pieceUnicode = " ";

                unicodeArray[i][j] = pieceUnicode;
            }
        }

        assertEquals(unicodeArray, bu.getBoardImageAsUnicode());
    }

}
