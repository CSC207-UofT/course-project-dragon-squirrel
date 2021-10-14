import piece.Color;

public class Player {
    private String ID;
    private Color color;
    private boolean status;     // This tells whether a player is in its turn to move

    public Player(String ID) { this.ID = ID; }

    public String getID() {
        return ID;
    }

    public Color getColor() {
        return color;
    }
}
