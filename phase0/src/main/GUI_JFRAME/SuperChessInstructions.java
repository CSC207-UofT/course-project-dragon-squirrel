package GUI_JFRAME;

import javax.swing.*;
import java.awt.*;

public class SuperChessInstructions extends JFrame{
    private final JTextPane instructions = new JTextPane();
    private final JTextPane instructions1 = new JTextPane();

    JTable setAttackAndHealthTable(){
        String[][] data = {
                { "Piece", "Pawn", "Knight", "Bishop", "Rook", "Queen", "King" },
                { "Health points", "5", "3", "4", "4", "2", "2" },
                { "Attack level", "6", "5", "1", "1", "2", "7" }
        };

        // Column Names. doesn't work without this...
        String[] columnNames = {"Piece", "Pawn", "Knight", "Bishop", "Rook", "Queen", "King"};

        JTable AttackAndHealth = new JTable(data, columnNames);
        AttackAndHealth.setShowGrid(true);
        AttackAndHealth.setBorder(BorderFactory.createLineBorder(new Color(84, 249, 255)));

        return AttackAndHealth;
    }

    void displayTable(){
        setTitle("Attack and Health Points");
        this.add(setAttackAndHealthTable());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(true);

        setSize(600, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void display(){
        setTitle("Super Chess Instructions");
        instructions.setEditable(false);

        // instructions
        instructions.setText("Please reed the following INSTRUCTIONS. \n \n \n" +
                "Each piece has health points and an attack level. An attack counts as a move wherein the " +
                "attacking piece does not actually move. The attacked piece must be in the attacker's line of offence: " +
                "the attacker must be able to move to the attacked piece's position according to its piece behaviours. " +
                "This is so that when the piece is captured, the attacking piece can take its position. " +
                "A piece is captured when it's health points are depleted. \n \n" +
                "Below are the corresponding health points and attack levels. \n \n \n");

        instructions1.setText("\n \n \nThe land of super chess is extraordinary!!! There are rivers, bridges, " +
                "home safe zones, and normal land. Piece behaviour changes according to the land type. \n \n \n" +

                "River (blue): Only the pawn can cross the river. All other pieces must use the bridge. However, " +
                "the knight can jump over the river as long as it lands on a land type other than the river. " +
                "The pawn is not visible in the river because it is \"submerged\". \n \n" +

                "Bridges (brown) are elevated. Therefore, pieces cannot attack a piece on the other side of the bridge. " +
                "However, pieces can attack a piece on the bridge. If a piece is on the bridge, due to the high " +
                "altitude, it can attack all visible pieces. All pieces can use the bridge and thus a piece can move " +
                "onto and over the bridge as it pleases.\n \n" +

                "Home safe zones (green): If a piece is in its own home safe zone, it cannot be attacked. However, it " +
                "is still visible from the bridge, therefore pieces in its own home safe zone can still be attacked " +
                "by pieces on the bridge. If a piece is in the opponent's home safe zone, it will be defenceless; " +
                "opponent pieces can attack it, but it cannot attack opponent pieces. \n \n" +

                "Normal land (white): no extra rules apply.");

        instructions1.setEditable(false);

        instructions.insertComponent(setAttackAndHealthTable());
        instructions.insertComponent(instructions1);

        this.add(instructions);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(true);

        setSize(800, 820);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
