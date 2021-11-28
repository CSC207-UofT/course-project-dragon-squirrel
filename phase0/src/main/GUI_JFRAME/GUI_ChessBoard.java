package GUI_JFRAME;

import javax.swing.*;
import java.awt.*;

public class GUI_ChessBoard extends JPanel {

    private PieceIcon[] icons = IconUpdater.init();

    //initialize the board
    public void ini(){
        GridLayout gridLayout = new GridLayout(8, 8);

        this.setLayout(gridLayout);
        add_piece(icons);

        setSize(800, 800);
        setVisible(true);
    }

    void add_piece(PieceIcon[] icons){

        int row = -1;
        for (int i = 0; i < icons.length; i++) {
            if (i % 8 == 0) row++; // increment row number
            icons[i].set(i, row);
            this.add(icons[i]);
        }
    }

    //the method that adds piece lable to the panel
    //switch pieces position by changing the Icon array
    public void sw_piece(int startX, int startY, int targetX, int targetY){
        int start = startY * 8 + startX;
        int target = targetY * 8 + targetX;
        this.removeAll();
        PieceIcon target_piece = icons[target];
        icons[target] = icons[start];
        icons[start] = target_piece;
        add_piece(icons);

    }

    //undo visualization
    public void undo(){
    }

    public PieceIcon[] getIcons(){
        return icons;
    }

    public GUI_ChessBoard(){
        GUI_ChessBoard board = new GUI_ChessBoard();
    }
}
