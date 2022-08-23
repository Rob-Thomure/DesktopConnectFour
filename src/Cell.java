
import javax.swing.*;

public class Cell extends JButton {

    public Cell(String cellNum) {
        super(cellNum);
        setFocusPainted(false);
        setName(String.format("Button%s", cellNum));
    }
}
