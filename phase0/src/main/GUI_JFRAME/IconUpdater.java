package GUI_JFRAME;

import piece.Piece;

public class IconUpdater {
    private static final PieceIcon wr = new PieceIcon("\u2656");
    private static final PieceIcon wkn = new PieceIcon("\u2568");
    private static final PieceIcon wb = new PieceIcon("\u2657");
    private static final PieceIcon wq = new PieceIcon("\u2655");
    private static final PieceIcon wk = new PieceIcon("\u2654");
    private static final PieceIcon wp = new PieceIcon("\u2659");

    private static final PieceIcon br = new PieceIcon("\u265C");
    private static final PieceIcon bkn = new PieceIcon("\u256E");
    private static final PieceIcon bb = new PieceIcon("\u265D");
    private static final PieceIcon bq = new PieceIcon("\u265B");
    private static final PieceIcon bk = new PieceIcon("\u265A");
    private static final PieceIcon bp = new PieceIcon("\u265F");

    private static final PieceIcon em = new PieceIcon("");


    public static PieceIcon[] init(){
        return new PieceIcon[]{
                br, bkn, bb, bk, bq, bb, bkn, br,
                bp, bp, bp, bp, bp, bp, bp, bp,

                em, em, em ,em, em, em, em ,em,
                em, em, em ,em, em, em, em ,em,

                wp, wp, wp, wp, wp ,wp ,wp ,wp,
                wr, wkn, wb, wk, wq, wb, wkn, wr,
        };
    }

    public static PieceIcon[] reload(){
        return new PieceIcon[0];
    }


}
