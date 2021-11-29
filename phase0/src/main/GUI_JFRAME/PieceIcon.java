package GUI_JFRAME;

import Board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PieceIcon extends JLabel {
    Font font = new Font("Ariel", 1, 45);
    Color W_background = new Color(222, 184, 135);
    Color B_background = new Color(90, 50, 10);
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

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected)
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 8));
        else
            setBorder(null);
    }

    public void toggleSelected() {
        selected = !selected;

        if (selected)
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 8));
        else
            setBorder(null);
    }

    public void unselect() {
        selected = false;
        setBorder(null);
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;

        if (highlighted)
            setBorder(BorderFactory.createLineBorder(Color.GREEN, 8));
        else if (!selected)
            setBorder(null);
    }
}