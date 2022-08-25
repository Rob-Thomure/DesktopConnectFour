import java.util.HashMap;
import java.util.Map;

public class BoardSlots {
    private static BoardSlots boardSlotsInstance = null;
    private final Map<String, BoardSlot> boardSlotMap;

    private BoardSlots() {
        this.boardSlotMap = new HashMap<>();
        fillBoardSlotMap();
    }

    public static BoardSlots getInstance() {
        if (boardSlotsInstance == null) {
            boardSlotsInstance = new BoardSlots();
        }
        return boardSlotsInstance;
    }

    private void fillBoardSlotMap() {
        for (int row = 6; row > 0; row--) {
            for (char column = 'A'; column < 'H'; column++) {
                String cellName = String.format("Button%s%s", column, row);
                BoardSlot boardSlot = new BoardSlot(cellName, row, Character.toString(column) , SlotStatus.OPEN);
                boardSlotMap.put(cellName, boardSlot);
            }
        }
    }

    public BoardSlot getBoardSlot(String slot) {
        return boardSlotMap.get(slot);
    }

    public BoardSlot getNextOpenSlot(BoardSlot selectedBoardSlot) {
        String column = selectedBoardSlot.getColumn();


        for (int i = 1; i < 7; i++) {
            String boardSlotToCheck = String.format("Button%s%s", column, i);
            BoardSlot boardSlot = boardSlotMap.get(boardSlotToCheck);
            if (boardSlot.getStatus().equals(SlotStatus.OPEN)) {
                return boardSlot;
            }
        }
        return null;
    }
}
