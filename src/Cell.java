
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton implements ActionListener {
    Game game = new Game();

    public Cell(String cellNum) {
        super(" ");
        setFocusPainted(false);
        setName(String.format("%s", cellNum));
        addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cellName = this.getName();
        game.takeTurn(cellName);
    }
}
