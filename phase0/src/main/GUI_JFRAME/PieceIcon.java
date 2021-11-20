package GUI_JFRAME;

import javax.swing.*;
import java.awt.*;

public class PieceIcon extends JLabel {
    Font font = new Font("Ariel", 1, 45);
    Color W_background = new Color(222, 184, 135);
    Color B_background = new Color(90, 50, 10);

    PieceIcon(String unicode){
        super(unicode);
    }

    void set(int idx, int row){

        setOpaque(true);
        setFont(font);

        setBackground((idx+row)%2 == 0 ? B_background : W_background); // Board background Color
        setHorizontalAlignment((SwingConstants.CENTER));
    }
}