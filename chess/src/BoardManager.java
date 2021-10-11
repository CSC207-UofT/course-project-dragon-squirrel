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


    public Board getBoard() {
        return board;
    }

    /**
     * Move the piece that is at board[oldX][oldY] to board[newX][newY]
     * Check whether the movement is valid and possibly attack another piece
     * @return  If successfully moved, return true
     */
    public boolean movePiece(int oldX, int oldY, int newX, int newY) {
        int clearValid = board.clearValidPath(oldX, oldY, newX, newY);


        // This if-else can be changed to switch statement

        if (clearValid == 0) {
            Piece p = board.removePiece(oldX, oldY);
            board.addPiece(p, newX, newY);
            return true;
        }

        if (clearValid == 1) {
            board.addPiece();
            return true;
        }

        if (clearValid == 2)
            return false;
        else {
            //code for knights and other stuff
        }

        return false;

//        if (isValidMove()) {
//            board.addPiece();
//            board.removePiece();
//        }
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
