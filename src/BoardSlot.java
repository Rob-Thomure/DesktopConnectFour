
public class BoardSlot {
    private final String slot;
    private final int row;
    private final String column;
    private SlotStatus status;

    public BoardSlot(String slot, int row, String column, SlotStatus status) {
        this.slot = slot;
        this.row = row;
        this.column = column;
        this.status = status;
    }

    public String getSlot() {
        return slot;
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
    public String toString() {
        return "BoardSlot{" +
                "slot='" + slot + '\'' +
                ", row=" + row +
                ", column='" + column + '\'' +
                ", status=" + status +
                '}';
    }
}
