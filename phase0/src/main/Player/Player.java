package Player;

import piece.Color;

import java.io.Serializable;

public class Player implements Serializable {
    private String ID;
    private Color color;
    private boolean status;     // This tells whether a player is in its turn to move

    public Player(String ID) { this.ID = ID; }

    public Player(Color color) { this.color = color; }

    public String getID() {
        return ID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

}
