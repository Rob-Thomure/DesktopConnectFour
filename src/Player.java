
public enum Player {
    PLAYER1("X"),
    PLAYER2("O");

    final String value;

    Player(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
