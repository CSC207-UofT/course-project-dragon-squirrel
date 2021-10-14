public class UI {
    CommandSender cs;

    /**
     * Say the player clicks the move button
     */
    public void onButtonClick() {
        cs.movePiece(0,0,0,0);
    }

    // Maybe it shows something and receives user input?
    // No idea about how to design interactive UI yet
}
