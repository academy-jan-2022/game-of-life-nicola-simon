package kata;

public class Board {
    private final Boolean[][] currentState;

    public Board(Boolean[][] input) {
        this.currentState = input;
    }

    public boolean getCell(int x, int y) {
        return currentState[y][x];
    }

    public int getNumberOfRows() {
        return currentState.length;
    }

    public Boolean[] getRowAtIndex(int index) {
        return currentState[index];
    }

    public int getNumberOfColumns() {
        return currentState[0].length;
    }

    public boolean willBeAlive(int y, int x) {
        return false;
    }
}
