
import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);
        setTitle("Connect Four");
        setLocationRelativeTo(null);

        for (int row = 6; row > 0; row--) {
            for (char column = 'A'; column < 'H'; column++) {
                add(new Cell(String.format("%c%d", column, row)));
            }
        }

        setLayout(new GridLayout(6, 7));
        setVisible(true);
    }
}