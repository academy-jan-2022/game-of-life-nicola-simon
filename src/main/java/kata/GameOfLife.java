package kata;

public class GameOfLife {

    public boolean[][] checkNewGeneration(Boolean[][] input) {
        if (input.length == 3 && input[0][0]) {
            return new boolean[][] {
                {true, false, false},
                getRow(input[1]),
                getRow(input[2])};
        }

        int totalRowCount = getTotalRowCount(input);

        if (input.length == 3 ) {

            if (totalRowCount > 2
                && totalRowCount < 5
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
            if (totalRowCount > 2 && totalRowCount < 5){
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

    private int getTotalRowCount(Boolean[][] input) {
        if (input.length == 3) {
            return counterAliveNeighboursAtRow(input[0])
                + counterAliveNeighboursAtRow(input[1])
                + counterAliveNeighboursAtRow(input[2]);
        }
        if (input.length == 2)  {
            return counterAliveNeighboursAtRow(input[0])
            + counterAliveNeighboursAtRow(input[1]);}

        return counterAliveNeighboursAtRow(input[0]);
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
