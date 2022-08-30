import java.awt.*;

public class Game {
    PlayerTurn playerTurn;
    Cells cells;

    public Game() {
        this.playerTurn = PlayerTurn.getInstance();
        this.cells = Cells.getInstance();
    }

    public void takeTurn(String cellName) {
        Cell cell = cells.getCell(cellName);
        Cell nextOpenCell = cells.getNextOpenCell(cell);
        if (null != nextOpenCell) {
            Player player = playerTurn.getPlayerTurn();
            nextOpenCell.setStatus(CellStatus.findByValue(player.getValue()));
            checkGameOver();
            playerTurn.changePlayerTurn();
        }
    }

    public void checkGameOver() {
        checkHorizontal();
        checkVertical();
        checkDiagonalRight();
        checkDiagonalLeft();
    }

    private void checkHorizontal() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                Cell cell1 = cells.getCell(String.format("Button%c%d", 'A' + j, 1 + i));
                Cell cell2 = cells.getCell(String.format("Button%c%d", 'B' + j, 1 + i));
                Cell cell3 = cells.getCell(String.format("Button%c%d", 'C' + j, 1 + i));
                Cell cell4 = cells.getCell(String.format("Button%c%d", 'D' + j, 1 + i));
                checkForMatchingCells(cell1, cell2, cell3, cell4);
            }
        }
    }

    private void checkVertical() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                Cell cell1 = cells.getCell(String.format("Button%c%d", 'A' + j, 1 + i));
                Cell cell2 = cells.getCell(String.format("Button%c%d", 'A' + j, 2 + i));
                Cell cell3 = cells.getCell(String.format("Button%c%d", 'A' + j, 3 + i));
                Cell cell4 = cells.getCell(String.format("Button%c%d", 'A' + j, 4 + i));
                checkForMatchingCells(cell1, cell2, cell3, cell4);
            }
        }
    }

    private void checkDiagonalRight() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Cell cell1 = cells.getCell(String.format("Button%c%d", 'A' + j, 1 + i));
                Cell cell2 = cells.getCell(String.format("Button%c%d", 'B' + j, 2 + i));
                Cell cell3 = cells.getCell(String.format("Button%c%d", 'C' + j, 3 + i));
                Cell cell4 = cells.getCell(String.format("Button%c%d", 'D' + j, 4 + i));
                checkForMatchingCells(cell1, cell2, cell3, cell4);
            }
        }
    }

    private void checkDiagonalLeft() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Cell cell1 = cells.getCell(String.format("Button%c%d", 'G' - j, 1 + i));
                Cell cell2 = cells.getCell(String.format("Button%c%d", 'F' - j, 2 + i));
                Cell cell3 = cells.getCell(String.format("Button%c%d", 'E' - j, 3 + i));
                Cell cell4 = cells.getCell(String.format("Button%c%d", 'D' - j, 4 + i));
                checkForMatchingCells(cell1, cell2, cell3, cell4);
            }
        }
    }

    private void checkForMatchingCells(Cell cell1, Cell cell2, Cell cell3, Cell cell4) {
        if (cell1.getStatus().getValue().equals(playerTurn.getPlayerTurn().getValue())
                && cell2.getStatus().getValue().equals(playerTurn.getPlayerTurn().getValue())
                && cell3.getStatus().getValue().equals(playerTurn.getPlayerTurn().getValue())
                && cell4.getStatus().getValue().equals(playerTurn.getPlayerTurn().getValue())) {
            cell1.setBackground(Color.yellow);
            cell2.setBackground(Color.yellow);
            cell3.setBackground(Color.yellow);
            cell4.setBackground(Color.yellow);
            playerTurn.setGameOver();
        }
    }
}
