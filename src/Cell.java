
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton implements ActionListener {
    static String player;

    public Cell(String cellNum) {
        super(" ");
        setFocusPainted(false);
        setName(String.format("Button%s", cellNum));
        addActionListener(this);
        player = "X";

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.setText(player);
        player = player.equals("X") ? "O" : "X";
    }
}
