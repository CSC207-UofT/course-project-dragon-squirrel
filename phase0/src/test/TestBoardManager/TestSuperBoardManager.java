package TestBoardManager;

import BoardManager.SuperBoardManager;
import org.junit.Before;
import org.junit.Test;
import piece.*;
import piece.Color;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSuperBoardManager {

    SuperBoardManager sbm;

    @Before
    public void before(){
        sbm = new SuperBoardManager();
    }

    @Test(timeout = 50)
    public void TestresetBoard(){
        SuperPieceDecorator[][] Piece2dArray = new SuperPieceDecorator[13][10];

        // initialize white pieces
        Piece2dArray[12][0] = new SuperPieceDecorator(new Rook("rook_l", piece.Color.WHITE), 4, 1);
        Piece2dArray[12][2] = new SuperPieceDecorator(new Knight("knight_l", piece.Color.WHITE), 3, 5);
        Piece2dArray[12][3] = new SuperPieceDecorator(new Bishop("bishop_l", piece.Color.WHITE), 4, 1);
        Piece2dArray[12][4] = new SuperPieceDecorator(new Queen("queen", piece.Color.WHITE), 2, 2);
        Piece2dArray[12][5] = new SuperPieceDecorator(new King("king", piece.Color.WHITE), 2, 7);
        Piece2dArray[12][6] = new SuperPieceDecorator(new Bishop("bishop_r", piece.Color.WHITE), 4, 1);
        Piece2dArray[12][7] = new SuperPieceDecorator(new Knight("knight_r", piece.Color.WHITE), 3, 5);
        Piece2dArray[12][9] = new SuperPieceDecorator(new Rook("rook_r", piece.Color.WHITE), 4, 1);

        // initialize white pawns
        for (int i = 0; i < 10; i++) {
            String name = "pawn_" + i;
            Piece2dArray[11][i] = new SuperPieceDecorator(new Pawn(name, piece.Color.WHITE), 5, 6);
        }

        // initialize black pieces
        Piece2dArray[0][0] = new SuperPieceDecorator(new Rook("rook_l", piece.Color.BLACK), 4, 1);
        Piece2dArray[0][2] = new SuperPieceDecorator(new Knight("knight_l", piece.Color.BLACK), 3, 5);
        Piece2dArray[0][3] = new SuperPieceDecorator(new Bishop("bishop_l", piece.Color.BLACK), 4, 1);
        Piece2dArray[0][4] = new SuperPieceDecorator(new Queen("queen", piece.Color.BLACK), 2, 2);
        Piece2dArray[0][5] = new SuperPieceDecorator(new King("king", piece.Color.BLACK), 2, 7);
        Piece2dArray[0][6] = new SuperPieceDecorator(new Bishop("bishop_r", piece.Color.BLACK), 4, 1);
        Piece2dArray[0][7] = new SuperPieceDecorator(new Knight("knight_r", piece.Color.BLACK), 3, 5);
        Piece2dArray[0][9] = new SuperPieceDecorator(new Rook("rook_r", piece.Color.BLACK), 4, 1);

        // initialize black pawns
        for (int i = 0; i < 10; i++) {
            String name = "pawn_" + i;
            Piece2dArray[1][i] = new SuperPieceDecorator(new Pawn(name, Color.BLACK), 5, 6);
        }

        // initialize remaining board with no pieces
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                Piece2dArray[i][i] = null;
            }
        }

        Piece2dArray[0][1] = null;
        Piece2dArray[0][8] = null;
        Piece2dArray[12][1] = null;
        Piece2dArray[12][8] = null;

        sbm.getBoard().reset(Piece2dArray);
        assertEquals(Piece2dArray, sbm.getBoard().getBoard());
    }

}
