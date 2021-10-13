// 8x8 array of spaces containing pieces

import java.util.ArrayList;

public class Board {

    private Space[][] spaces;    // grid representing all valid squares/cells/spaces

    // Instantiation without parameters constructs the default board
    public Board() {
        this.defaultBoard();
    }

    // @x the x coordinate of the space
    // @y the y coordinate of the space
    // @return the space of the given x and y coordinates
    public Space getspace(int x, int y) {
        if(x < 0 || x > 7 || y < 0 || y > 7){
            throw new Exception("index out of bound(s)");
        }
        return spaces[x][y];
    }

    // Initializes the default chess board
    public void defaultBoard()
    {

        // initialize white pieces
        spaces[7][0] = new space(0, 0, new Rook(true));
        spaces[7][1] = new space(0, 1, new Knight(true));
        spaces[7][2] = new space(0, 2, new Bishop(true));
        spaces[7][3] = new space(0, 0, new Queen(true));
        spaces[7][4] = new space(0, 1, new King(true));
        spaces[7][5] = new space(0, 2, new Bishop(true));
        spaces[7][7] = new space(0, 1, new Knight(true));
        spaces[7][6] = new space(0, 0, new Rook(true));
        spaces[6][0] = new space(1, 0, new Pawn(true));
        spaces[6][1] = new space(1, 1, new Pawn(true));
        spaces[6][2] = new space(1, 0, new Pawn(true));
        spaces[6][3] = new space(1, 1, new Pawn(true));
        spaces[6][4] = new space(1, 0, new Pawn(true));
        spaces[6][5] = new space(1, 1, new Pawn(true));
        spaces[6][6] = new space(1, 0, new Pawn(true));
        spaces[6][7] = new space(1, 1, new Pawn(true));

        // initialize black pieces
        spaces[0][0] = new space(0, 0, new Rook(false));
        spaces[0][1] = new space(0, 1, new Knight(false));
        spaces[0][2] = new space(0, 2, new Bishop(false));
        spaces[0][3] = new space(0, 0, new Queen(false));
        spaces[0][4] = new space(0, 1, new King(false));
        spaces[0][5] = new space(0, 2, new Bishop(false));
        spaces[0][6] = new space(0, 1, new Knight(false));
        spaces[0][7] = new space(0, 0, new Rook(false));
        spaces[1][0] = new space(1, 0, new Pawn(false));
        spaces[1][1] = new space(1, 1, new Pawn(false));
        spaces[1][2] = new space(1, 0, new Pawn(false));
        spaces[1][3] = new space(1, 1, new Pawn(false));
        spaces[1][4] = new space(1, 0, new Pawn(false));
        spaces[1][5] = new space(1, 1, new Pawn(false));
        spaces[1][6] = new space(1, 0, new Pawn(false));
        spaces[1][7] = new space(1, 1, new Pawn(false));

        // initialize remaining spaces with no pieces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spaces[i][j] = new space(i, j, null);
            }
        }
    }

}
