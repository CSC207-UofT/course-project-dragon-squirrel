package GUI_JFRAME;

import javax.swing.*;
import java.awt.*;


public class PieceIcon extends JLabel {
    Font font = new Font("Ariel", Font.PLAIN, 45);
    Color W_background = new Color(222, 184, 135);
    Color B_background = new Color(140, 100, 60);
    boolean selected;
    boolean highlighted;

    PieceIcon(String unicode){
        super(unicode);
        selected = false;
    }

    void set(int idx, int row){
        setOpaque(true);
        setFont(font);

        setBackground((idx+row)%2 == 0 ? B_background : W_background); // Board background Color
        setHorizontalAlignment((SwingConstants.CENTER));
    }

    void setSuper(){
        setOpaque(true);
        setFont(font);
        setHorizontalAlignment((SwingConstants.CENTER));
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected)
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        else
            setBorder(null);
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
        if (highlighted)
            setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        else if (!selected)
            setBorder(null);
    }
}