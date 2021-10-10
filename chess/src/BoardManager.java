/**
 * This should be in the controller/presenter layer
 * It should receive some input from players and send command to a Board instance
 * It should reflect the changes on the board and let players know
 * Perhaps we can separate controller and presenter to 2 classes
 *
 * Not sure how to design this part yet
 */
public class BoardManager {
    private Board board;
    //

    /**
     * Move the piece that is at board[oldCoorX][oldCoorY] to board[newCoorX][newCoorY]
     * Check whether the movement is valid and possibly attack another piece
     * @return  If successfully moved, return true
     */
    public boolean movePiece(int oldCoorX, int oldCoorY, int newCoorX, int newCoorY) {

//        if (isValidMove()) {
//            board.addPiece();
//            board.removePiece();
//        }

        return false;
    }

    /**
     * End a player's round, and let the other player move
     */
    public void passRound() {

    }

    /**
     * This returns an update to whatever in the upper layer
     *
     * Depends on the implementation, it could return different things:
     * ex. a full image (doesn't have to be a picture) of the current board, and players can see it directly
     * ex. updates/changes from the last round, so UI handles the update info and shows the correct things
     */
    public Object getBoardUpdate() {
        return null;
    }

    private boolean isValidMove(int X, int Y) {
        // ....
        return false;
        }
}
