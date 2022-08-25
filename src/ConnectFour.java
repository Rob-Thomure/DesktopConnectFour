
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectFour extends JFrame {
    static Map<String, Cell> cells = new HashMap<>();

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);
        setTitle("Connect Four");
        setLocationRelativeTo(null);


        for (int row = 6; row > 0; row--) {
            for (char column = 'A'; column < 'H'; column++) {
                String cellName = String.format("Button%c%d", column, row);
                Cell cell = new Cell(cellName);
                add(cell);
                cells.put(cellName, cell);
            }
        }
        setLayout(new GridLayout(6, 7));
        setVisible(true);
    }

    public static void setCell(String cellName, String player) {
        Cell cell = cells.get(cellName);
        cell.setText(player);
    }
}