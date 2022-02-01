package kata;

import java.util.ArrayList;
import java.util.List;

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
        if (x == 1) {
            if (currentState.length > 1 && currentState[1][0] && currentState[1][1]) {
                return true;
            }

            if (!currentState[0][0] && !currentState[0][2])
                return false;
            return true;
        }
        return false;
    }

    public Boolean[] getNeighbours(int x, int y) {
        var neighbours = new ArrayList<Boolean>();
        Boolean isOnRightEdge = currentState[0].length - 1 == x;

        if (!isOnRightEdge) {
            neighbours.add(currentState[y][x+1]);
        }
        return neighbours.toArray(new Boolean[0]);
    }
}
