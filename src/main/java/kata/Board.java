package kata;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private final Boolean[][] currentState;

    public Board(Boolean[][] input) {
        this.currentState = input;
    }

    public int getNumberOfRows() {
        return currentState.length;
    }

    public int getNumberOfColumns() {
        return currentState[0].length;
    }

    public boolean willBeAlive(int y, int x) {
        if (x == 1) {
            if (currentState.length > 1 && currentState[1][0] && currentState[1][1]) {
                return true;
            }

            return currentState[0][0] || currentState[0][2];
        }
        return false;
    }

    public Boolean[] getNeighbours(int x, int y) {
        var neighbours = new ArrayList<Boolean>();

        boolean isOnRightEdge = currentState[0].length - 1 == x;
        boolean isOnLeftEdge = x == 0;
        boolean isOnTopEdge = y == 0;
        boolean isOnBottomEdge = currentState.length - 1 == y;

        if (!isOnTopEdge && !isOnLeftEdge) {
            neighbours.add(currentState[y-1][x-1]);
        }
        if (!isOnBottomEdge && !isOnRightEdge){
            neighbours.add(currentState[y+1][x+1]);
        }
        if (!isOnTopEdge && !isOnRightEdge){
            neighbours.add(currentState[y-1][x+1]);
        }
        if (!isOnBottomEdge && !isOnLeftEdge){
            neighbours.add(currentState[y+1][x-1]);
        }
        if (!isOnTopEdge) {
            neighbours.add(currentState[y-1][x]);
        }
        if (!isOnBottomEdge){
            neighbours.add(currentState[y+1][x]);
        }
        if (!isOnRightEdge) {
            neighbours.add(currentState[y][x+1]);
        }
        if (!isOnLeftEdge){
            neighbours.add(currentState[y][x-1]);
        }

        return neighbours.toArray(new Boolean[0]);
    }

    public Boolean[] filterAliveNeighbours(Boolean[] neighbours) {
        var filteredArray = Arrays.stream(neighbours).filter(x -> x).toList();
        return filteredArray.toArray(new Boolean[0]);
    }
}
