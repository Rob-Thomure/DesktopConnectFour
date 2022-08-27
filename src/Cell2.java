import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell2 extends JButton implements ActionListener {
    Game game = new Game();
    private final String cellNum;
    private final int row;
    private final String column;
    private SlotStatus status;

    public Cell2(String cellNum, int row, String column, SlotStatus status) {
        super(" ");
        setFocusPainted(false);
        setName(String.format("%s", cellNum));
        addActionListener(this);
        this.cellNum = cellNum;
        this.row = row;
        this.column = column;
        this.status = status;
    }

    public String getCellNum() {
        return cellNum;
    }

    public int getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public boolean setStatus(SlotStatus slotStatus) {
        if (status.equals(SlotStatus.OPEN) && !slotStatus.equals(SlotStatus.OPEN)) {
            status = slotStatus;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cellName = this.getName();
        game.takeTurn(cellName);
    }

    @Override
    public String toString() {
        return "BoardSlot{" +
                "slot='" + cellNum + '\'' +
                ", row=" + row +
                ", column='" + column + '\'' +
                ", status=" + status +
                '}';
    }
}
