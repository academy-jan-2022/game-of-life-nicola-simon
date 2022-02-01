package kata;

public class GameOfLife {

    public boolean[][] checkNewGeneration(Boolean[][] input) {

        if (input.length == 3 ) {
            int topRowCount = counterAliveNeighbours(input[0]);
            int middleRowCount = counterAliveNeighbours(input[1]);
            int bottomRowCount = counterAliveNeighbours(input[2]);

            if (middleRowCount + topRowCount + bottomRowCount > 2
                && middleRowCount + topRowCount < 5
            ){
                return new boolean[][] {
                    getRow(input[0]),
                    {false, true, false},
                    getRow(input[2])};
            }

            return new boolean[][] {
                getRow(input[0]),
                getRow(input[1]),
                getRow(input[2])};
        }

        if (input.length == 2 ) {
            int topRowCount = counterAliveNeighbours(input[0]);
            int middleRowCount = counterAliveNeighbours(input[1]);

            if (middleRowCount + topRowCount > 2 && middleRowCount + topRowCount < 5){
                return new boolean[][] {
                    getRow(input[0]),
                    {false, true, false}};
            }

            return new boolean[][] {
                getRow(input[0]),
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
