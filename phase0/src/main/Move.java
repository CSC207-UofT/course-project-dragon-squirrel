// keeps track of starting and ending position and player who's turn it is

public class Move {

    private Player player;
    private Space start;
    private Space end;
    private Piece moved;    // piece to move
    private Piece killed;   // enemy piece that was killed (or null)
    private boolean castled;    // if the king castled with a rook

    public Move(Player player, Space start, Space end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.moved = start.getPiece();
    }

    public boolean isCastled(){
        return this.castled;
    }

    public void setCastled(boolean castled){
        this.castled = castled;
    }

}