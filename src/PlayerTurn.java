
public class PlayerTurn {
    private static PlayerTurn playerTurnInstance = null;
    private Player playerTurn;

    private PlayerTurn() {
        this.playerTurn = Player.PLAYER1;
    }

    public static PlayerTurn getInstance() {
        if (playerTurnInstance == null) {
            playerTurnInstance = new PlayerTurn();
        }
        return playerTurnInstance;
    }

    public void changePlayerTurn() {
        playerTurn = playerTurn.equals(Player.PLAYER1) ? Player.PLAYER2 : Player.PLAYER1;
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }
}
