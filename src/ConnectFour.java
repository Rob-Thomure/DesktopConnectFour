import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    Cells cells = Cells.getInstance();

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(327, 375);
        setLayout(null);
        setTitle("Connect Four");
        setLocationRelativeTo(null);

        JPanel gamePanel = new JPanel(new GridLayout(6, 7));
        gamePanel.setSize(310, 300);
        for (int row = 6; row > 0; row--) {
            for (char column = 'A'; column < 'H'; column++) {
                String cellName = String.format("Button%c%d", column, row);
                Cell cell = new Cell(cellName, row, Character.toString(column), CellStatus.OPEN);
                cell.setBackground(Color.WHITE);
                gamePanel.add(cell);
                cells.addCell(cell);
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
}
