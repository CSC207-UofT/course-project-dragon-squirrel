package super_chess;

import super_chess.super_piece.SuperColor;

public interface SuperPlayer {
    String getSuperID();
    SuperColor getSuperColor();
    void setSuperColor();
    boolean getSuperStatus();
    void setSuperStatus();

    // new features
}
