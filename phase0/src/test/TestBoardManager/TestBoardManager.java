package TestBoardManager;

import Board.Board;
import BoardManager.BoardManager;
import Command.MoveRecord;
import Player.Player;
import BoardManager.GameStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import piece.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBoardManager {

    int col;
    int row;
    Board b;
    Player activePlayer;
    GameStatus gameStatus;
    MoveRecord MR;
    BoardManager bm;

    @Before
    public void before(){
        col = 8;
        row = 8;
        b = new Board(col, row);
        activePlayer = new Player("bob");
        bm = new BoardManager();
        b = new Board(8, 8);
    }

    @After
    public void after(){
        b.reset(b.getBoard());
    }

    @Test(timeout = 50)
    public void TestgetBoard(){
        assertEquals(b.to2dStringArray(col, row), bm.getBoardAsString());
    }

    @Test(timeout = 50)
    public void TestgetPiece(){
        assertEquals("w_pawn_0", bm.getPiece(6, 0).getName());
    }

    @Test(timeout = 50)
    public void TestgetActivePlayer(){
        assertEquals("bob", bm.getActivePlayer().getID());
    }

    @Test(timeout = 50)
    public void TestsetActivePlayer(){
        Player newPlayer = new Player("joe");
        bm.setActivePlayer(newPlayer);
        assertEquals("joe", bm.getActivePlayer().getID());
    }

    @Test(timeout = 50)
    public void TestmovePiece(){
        assertEquals("vacant", bm.getBoard().getPiece(5, 0));
        bm.movePiece(6, 0, 5, 0);
        assertEquals("w_pawn_0", bm.getBoard().getPiece(5, 0));
    }

    @Test(timeout = 50)
    public void TestresetBoard(){
        Board newBoard = new Board(col, row);
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

        newBoard.reset(Piece2dArray);

        assertEquals(b, newBoard);
    }

}
