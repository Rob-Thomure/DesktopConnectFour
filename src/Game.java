
public class Game {
    PlayerTurn playerTurn;
    BoardSlots boardSlots;

    public Game() {
        this.playerTurn = PlayerTurn.getInstance();
        this.boardSlots = BoardSlots.getInstance();
    }

    public void takeTurn(String cellName) {
        BoardSlot selectedBoardSlot = boardSlots.getBoardSlot(cellName);
        BoardSlot nextOpenBoardSlot = boardSlots.getNextOpenSlot(selectedBoardSlot);
        if (null != nextOpenBoardSlot) {
            Player player = playerTurn.getPlayerTurn();     //*****************************
            String openBoardSlotName = nextOpenBoardSlot.getSlot();
            ConnectFour.setCell(openBoardSlotName, player.getValue());
            nextOpenBoardSlot.setStatus(SlotStatus.findByValue(player.getValue()));
            playerTurn.changePlayerTurn();
        }
    }
}
