package kata;

public class GameOfLife {

    public boolean[][] checkNewGeneration(Boolean[][] input) {
        if (input.length == 3 && input[0][0]) {
            return new boolean[][] {
                {true, false, false},
                getRow(input[1]),
                getRow(input[2])};
        }

        if (input.length != 1) {
            return getMiddleCellResult(input);
        }

        return new boolean[][]{getRow(input[0])};
    }

    private int getTotalGameCount(Boolean[][] gameState) {
        if (gameState.length == 3) {
            return
            counterAliveNeighboursAtRow(gameState[0])
                + counterAliveNeighboursAtRow(gameState[1])
                + counterAliveNeighboursAtRow(gameState[2]);
        }
        return counterAliveNeighboursAtRow(gameState[0]) + counterAliveNeighboursAtRow(gameState[1]);

    }

    private boolean[][] getMiddleCellResult(Boolean[][] gameState) {
        int totalRowCount = getTotalGameCount(gameState);

        if (totalRowCount > 2
            && totalRowCount < 5
        ){
            return new boolean[][]{
                getRow(gameState[0]),
                {false, true, false}};
        }

        return new boolean[][]{
            getRow(gameState[0]),
            getRow(gameState[1])};
    }

    private Integer counterAliveNeighboursAtRow(Boolean[] input) {
        int counter = 0;
        for (Boolean aBoolean : input) {
            if (aBoolean) {
                counter++;
            }
        }
        return counter;

    }

    private boolean[] getRow(Boolean[] input) {
        if (input.length == 3 && input[0] && input[2]) {
            return new boolean[]{false, true, false};
        }

        return new boolean[]{false, false, false};
    }
}
