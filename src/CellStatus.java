
public enum CellStatus {
    X("X"),
    O("O"),
    OPEN("OPEN");

    final String value;

    CellStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CellStatus findByValue(String value) {
        for (CellStatus element : values()) {
            if (element.value.equals(value)) {
                return element;
            }
        }
        return null;
    }
}
