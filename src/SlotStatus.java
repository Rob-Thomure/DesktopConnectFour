
public enum SlotStatus {
    X("X"),
    O("O"),
    OPEN("OPEN");

    final String value;

    SlotStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SlotStatus findByValue(String value) {
        for (SlotStatus element : values()) {
            if (element.value.equals(value)) {
                return element;
            }
        }
        return null;
    }
}
