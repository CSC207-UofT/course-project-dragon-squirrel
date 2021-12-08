package TestCommand;

import Board.Board;
import BoardManager.BoardManager;
import Command.ChessMove;
import Command.MoveType;
import org.junit.Before;
import org.junit.Test;
import piece.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestChessMove {

    BoardManager bm;
    int oldX;
    int oldY;
    int newX;
    int newY;
    PieceInterface oldPiece;
    PieceInterface newPiece;
    PieceInterface otherPiece;
    boolean firstMoveOfPieceDuringGame;
    MoveType typeOfMove;
    ChessMove cm;

    @Before
    public void before(){
        bm = new BoardManager();
        oldX = 0;
        oldY = 0;
        newX = 1;
        newY = 1;
        oldPiece = new Pawn("pawn_0", Color.WHITE);
        newPiece = new Pawn("pawn_1", Color.BLACK);
        otherPiece = new Rook("rook_l", Color.WHITE);
        firstMoveOfPieceDuringGame = false;
        typeOfMove = MoveType.REGULAR;
        cm = new ChessMove(bm, oldX, oldY, newX, newY, firstMoveOfPieceDuringGame, typeOfMove);
    }

    @Test(timeout = 50)
    public void TestgetOldX(){
        assertEquals(0, cm.getOldX());
    }

    @Test(timeout = 50)
    public void TestgetOldY(){
        assertEquals(0, cm.getOldY());
    }

    @Test(timeout = 50)
    public void TestgetNewX(){
        assertEquals(1, cm.getNewX());
    }

    @Test(timeout = 50)
    public void TestgetNewY(){
        assertEquals(1, cm.getNewY());
    }

    @Test(timeout = 50)
    public void TestgetOldPiece(){
        assertEquals("pawn_0", oldPiece.getName());
    }

    @Test(timeout = 50)
    public void TestgetNewPiece(){
        assertEquals("pawn_1", newPiece.getName());
    }

    @Test(timeout = 50)
    public void TestgetOtherPiece(){
        assertEquals("rook_l", otherPiece.getName());
    }

    @Test(timeout = 50)
    public void TestgetFirstMoveStatus(){
        assertFalse(cm.getFirstMoveStatus());
    }

    @Test(timeout = 50)
    public void TestgetMoveType(){
        assertEquals(MoveType.REGULAR, cm.getMoveType());
    }

    @Test(timeout = 50)
    public void TestgetBM(){
        Board board = new Board(8, 8);
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
        assertEquals(board.to2dStringArray(), cm.getBM().getBoard().to2dStringArray());
    }

}
