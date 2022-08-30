import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Cells {
    private static Cells cellsInstance = null;
    private final Map<String, Cell> cellsMap;

    private Cells() {
        this.cellsMap = new HashMap<>();
    }

    public static Cells getInstance() {
        if (cellsInstance == null) {
            cellsInstance = new Cells();
        }
        return cellsInstance;
    }

    public void addCell(Cell cell) {
        cellsMap.put(cell.getCellName(), cell);
    }

    public Cell getCell(String slot) {
        return cellsMap.get(slot);
    }

    public Cell getNextOpenCell(Cell selectedCell) {
        String column = selectedCell.getColumn();
        for (int i = 1; i < 7; i++) {
            String CellToCheck = String.format("Button%s%s", column, i);
            Cell cell = cellsMap.get(CellToCheck);
            if (cell.getStatus().equals(CellStatus.OPEN)) {
                return cell;
            }
        }
        return null;
    }

    public void resetGame() {
        for (Cell cell : cellsMap.values()) {
            cell.setText(" ");
            cell.resetStatus();
            cell.setBackground(Color.WHITE);
            PlayerTurn.getInstance().reset();
        }
    }
}
