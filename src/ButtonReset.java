import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonReset extends JButton implements ActionListener {

    public ButtonReset() {
        super("Reset");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cells.getInstance().resetGame();
    }
}
