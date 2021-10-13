// keeps track of who's turn it is, all the moves made, and the outcome.

public class GameManager {
    private Player[] players;
    private Board board;
    private Player current;     // who's turn it is
    private GameStatus status;
    private List<Move> moves;

    private void newGame(Player p1, Player p2){
        players[0] = p1;
        players[1] = p2;

        board.defaultBoard();

        if(p1.isWhite){
            this.current = p1;
        }else{
            this.current = p2;
        }
        moves.clear();  // reseting moves list for new game
    }

    public boolean isEnd(){
        return this.status != GameStatus.ACTIVE;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(GameStatus status){
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY){
        Space start = board.getSpace(startX, startY);
        Space end = board.getSpace(endX, endY);
        Move move = new Move(player, start, end);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player){
        Piece piece = move.getStart().getPiece();

        if(piece == null){
            return false;
        }
        if(player != current){
            return false;
        }
        if(piece.white() != player.white()){
            return false;
        }
        if(!piece.canMove(board, move.getStart(), move.getEnd())){
            return false;
        }

        Piece destination = move.getEnd().getPiece();

        if(destination != null){
            destination.setAlive(false);
            move.setKilled(destination);
        }
        if(piece != null && piece instanceof King && piece.isCastling()){
            move.setCastling(true);
        }

        moves.add(move);
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart.setPiece(null);

        if (destination != null && destination instanceof King) {
            if(player.isWhite()){
                this.setStatus(GameStatus.WHITE_WIN);
            }else{
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }
        if (this.current == players[0]) {
            this.current = players[1];
        }
        else {
            this.current = players[0];
        }
        return true;
    }
}