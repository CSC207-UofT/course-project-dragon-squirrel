// keeps track of starting and ending position and player who's turn it is

public class Move {
    private Player player;
    private Space start;
    private Space end;
    private Piece moved;    // piece to move
    private Piece killed;   // enemy piece that was killed (or null)
    private boolean castling;    // if the king is castling with a rook

    public Move(Player player, Space start, Space end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.moved = start.getPiece();
    }

    public void setKilled(Piece killed){
        this.killed = killed;
    }

    public boolean isCastling(){
        return this.castled;
    }

    public void setCastling(boolean castling){
        this.castling = castling;
    }
}