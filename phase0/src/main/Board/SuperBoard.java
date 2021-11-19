package Board;

import piece.PieceInterface;

public class SuperBoard extends Board{

    public static String[][] superBoardLand; // Each cell contains the name of the type of land

    public SuperBoard(int column, int row) {
        super(13, 10);
        superBoardLand = new String[13][10];
        superSetLand();
    }

    /**
     * @return river, bridge, black_zone, or white_zone according to land type at superBoardLand[X][Y]
     */
    public String getLandType(int X, int Y) {return superBoardLand[X][Y];}

    @Override
    public void reset(PieceInterface[][] board)
    {
        super.board = board;
    }

    public void superSetLand() {
        // river (r), bridge (b), black_zone (z), white_zone (x) ground (.)

        String s =  ".r.zzzz.r." +
                    ".r......r." +
                    "bbb....bbb" +
                    ".r......r." +
                    ".r......r." +
                    ".r..bb..r." +
                    "bbbrbbrbbb" +
                    ".r..bb..r." +
                    ".r......r." +
                    ".r......r." +
                    "bbb....bbb" +
                    ".r......r." +
                    ".r.xxxx.r.";

        // initialize type of land
        for (int k = 0; k < s.length(); k++) {
            char c = s.charAt(k);
            int i = k / 10;
            int j = k % 10;
            String land;

            if (c == 'r') {
                land = "river";
            } else if (c == 'b') {
                land = "bridge";
            } else if (c == 'z') {
                land = "black_zone";
            } else if (c == 'x') {
                land = "white_zone";
            } else {
                land = "ground";
            }

            superBoardLand[i][j] = land;
        }
    }
}
