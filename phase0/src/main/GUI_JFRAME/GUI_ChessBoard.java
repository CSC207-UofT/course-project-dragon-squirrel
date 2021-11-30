package GUI_JFRAME;

import Controller.CommandSender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class GUI_ChessBoard extends JFrame {
    // icons is an array list that store the initial stage of each pieces, note that empty space is considered as an
    // empty piece. We can, if that's the way, by changing the order of the list, to make moves.

    private PieceIcon[] icons = new PieceIcon[]{
            // white
            new PieceIcon("\u2656"), new PieceIcon("\u2658"), new PieceIcon("\u2657"),
            new PieceIcon("\u2655"), new PieceIcon("\u2654"), new PieceIcon("\u2657"),
            new PieceIcon("\u2658"), new PieceIcon("\u2656"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"), new PieceIcon("\u2659"), new PieceIcon("\u2659"),
            new PieceIcon("\u2659"),
            // empty
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "), new PieceIcon(" "),
            new PieceIcon(" "), new PieceIcon(" "),
            // black
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265F"),
            new PieceIcon("\u265F"), new PieceIcon("\u265F"), new PieceIcon("\u265C"),
            new PieceIcon("\u265E"), new PieceIcon("\u265D"), new PieceIcon("\u265B"),
            new PieceIcon("\u265A"), new PieceIcon("\u265D"), new PieceIcon("\u265E"),
            new PieceIcon("\u265C")
    };

    private CommandSender cs;
    private Point prevSelected;

    // TODO: Probably will change some code below, as we need to have operation on the board

    public GUI_ChessBoard(){

        cs = new CommandSender(true);

        // Add listener to every PieceIcon
        for (int i = 0; i < icons.length; i++) {
            int finalI = i;
            icons[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    unselectAll();
                    icons[finalI].setSelected(true);
                    Point selected = indexToCoordinate(finalI);

                    if (icons[finalI].highlighted) {
                        Point otherPoint = cs.pressMove(prevSelected.x, prevSelected.y, selected.x, selected.y);

                        // Move piece by changing JLabel's text
                        // TODO this is just temporary code for testing
                        // TODO try implement it in a nicer way (e.x. use BoardUpdater)
                        String actionPiece = icons[coordinateToIndex(prevSelected)].getText();
                        icons[coordinateToIndex(prevSelected)].setText(" ");
                        icons[coordinateToIndex(selected)].setText(actionPiece);

                        // for castling or en passant
                        if (otherPoint != null) {
                            // castling
                            if (otherPoint.x == 0 || otherPoint.x == 7) {
                                String otherPiece = icons[coordinateToIndex(otherPoint)].getText();
                                icons[coordinateToIndex(otherPoint)].setText(" ");
                                icons[coordinateToIndex(new Point(prevSelected.x,
                                        (selected.y == 6) ? 5 : 3))].setText(otherPiece);
                            }
                            else { // en passant, delete the captured pawn
                                icons[coordinateToIndex(otherPoint)].setText(" ");
                            }
                        }
                    }

                    if (icons[finalI].getText().equals(" "))
                        return;

                    showValidMove(selected.x, selected.y);

                    prevSelected = selected;
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

        }
    }

    void display(){
        setTitle("Chess board");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(8, 8);

        contentPane.setLayout(gridLayout);

        int row = -1;
        for (int i = 0; i < icons.length; i++)
        {
            if(i % 8 == 0) row ++; // increment row number
            icons[i].set(i, row);
            contentPane.add(icons[i]);
        } // i

        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void unselectAll() {
        for (PieceIcon icon: icons) {
            icon.unselect();
        }
    }

    private void unHighlightAll() {
        for (PieceIcon icon: icons) {
            icon.setHighlighted(false);
        }
    }

    private Point indexToCoordinate(int index) {
        int row = index / 8;
        int col = index % 8;

        return new Point(row, col);
    }

    private int coordinateToIndex(Point p) {
        return p.x * 8 + p.y;
    }

    private void showValidMove(int x, int y) {

        unHighlightAll();
        List<Point> validMoves = cs.passValidMove(new Point(x, y));
        for (Point position: validMoves) {
            icons[coordinateToIndex(position)].setHighlighted(true);
        }
    }

    // TODO: Allow pieces to move by interacting with other code, idea: by change the array of icons.

    // Here should be some code.

}
