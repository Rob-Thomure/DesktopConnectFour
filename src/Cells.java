import java.util.HashMap;
import java.util.Map;

public class Cells {
    private static Cells cellsInstance = null;
    private final Map<String, Cell2> cellsMap;

    private Cells() {
        this.cellsMap = new HashMap<>();
    }

    public static Cells getInstance() {
        if (cellsInstance == null) {
            cellsInstance = new Cells();
        }
        return cellsInstance;
    }

    public void addCell(Cell2 cell) {
        cellsMap.put(cell.getCellNum(), cell);
    }

    public Cell2 getCell(String slot) {
        return cellsMap.get(slot);
    }

    public Cell2 getNextOpenCell(BoardSlot selectedBoardSlot) {
        String column = selectedBoardSlot.getColumn();
        for (int i = 1; i < 7; i++) {
            String boardSlotToCheck = String.format("Button%s%s", column, i);
            Cell2 boardSlot = cellsMap.get(boardSlotToCheck);
            if (boardSlot.getStatus().equals(SlotStatus.OPEN)) {
                return boardSlot;
            }
        }
        return null;
    }
}
