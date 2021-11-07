package Player;

import piece.Color;

public interface SuperPlayer {
    String getSuperID();
    Color getSuperColor();
    void setSuperColor();
    boolean getSuperStatus();
    void setSuperStatus();

    // new features
}