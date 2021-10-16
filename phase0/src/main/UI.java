public class UI {
    CommandSender cs;

    /**
     * Say the player clicks the move button
     */
    public void onButtonClick() {
        boolean success;
        do {
            success = cs.makeMove(0, 0, 0, 0);
        } while (!success);

    }

    // Maybe it shows something and receives user input?
    // No idea about how to design interactive UI yet
}
