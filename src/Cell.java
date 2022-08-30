import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton implements ActionListener {
    Game game = new Game();
    private final String cellName;
    private final int row;
    private final String column;
    private CellStatus status;

    public Cell(String cellName, int row, String column, CellStatus status) {
        super(" ");
        setFocusPainted(false);
        setName(cellName);
        addActionListener(this);
        this.cellName = cellName;
        this.row = row;
        this.column = column;
        this.status = status;
    }

    public String getCellName() {
        return cellName;
    }

    public String getColumn() {
        return column;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus slotStatus) {
        if (status.equals(CellStatus.OPEN) && !slotStatus.equals(CellStatus.OPEN)) {
            this.setText(slotStatus.getValue());
            status = slotStatus;
        }
    }

    public void resetStatus() {
        status = CellStatus.OPEN;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cellName = this.getName();
        if (!PlayerTurn.getInstance().isGameOver()) {
            game.takeTurn(cellName);
        }
    }

    @Override
    public String toString() {
        return "BoardSlot{" +
                "slot='" + cellName + '\'' +
                ", row=" + row +
                ", column='" + column + '\'' +
                ", status=" + status +
                '}';
    }
}
