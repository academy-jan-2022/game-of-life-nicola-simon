package kata;

public class GameOfLife {

    public boolean[][] checkNewGeneration(Boolean[][] input) {

        if (input.length == 2 ) {
            if (input[1][2] && counterAliveNeighbours(input[0]) == 1){
                return new boolean[][] {
                    getRow(input[0]),
                    {false, true, false}};
            }

            return new boolean[][] {
                {false, false, false},
                getRow(input[1])};
        }

        return new boolean[][]{getRow(input[0])};
    }

    private Integer counterAliveNeighbours(Boolean[] input) {
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
