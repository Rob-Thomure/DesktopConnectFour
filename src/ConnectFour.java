
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ConnectFour extends JFrame {
    static Map<String, Cell> cells = new HashMap<>();

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(327, 375);
        setLayout(null);
        setTitle("Connect Four");
        setLocationRelativeTo(null);

        // TODO get rid of cells hashMap in this and use hashMap in Cells class
        // TODO to store and retrieve cells
        JPanel gamePanel = new JPanel(new GridLayout(6, 7));
        gamePanel.setSize(310, 300);
        for (int row = 6; row > 0; row--) {
            for (char column = 'A'; column < 'H'; column++) {
                String cellName = String.format("Button%c%d", column, row);
                Cell cell = new Cell(cellName);
                cell.setBackground(Color.WHITE);
                gamePanel.add(cell);
                cells.put(cellName, cell);
            }
        }
        add(gamePanel);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        navPanel.setLocation(0, 300);
        navPanel.setSize(310, 35);
        ButtonReset buttonReset = new ButtonReset();
        navPanel.add(buttonReset);
        add(navPanel);

        setVisible(true);


    }

    public static void setCell(String cellName, String player) {
        Cell cell = cells.get(cellName);
        cell.setText(player);
    }




}