package kata;

public class GameOfLife {

    private class Board {
        private final Boolean[][] currentState;

        public Board(Boolean[][] input) {
            this.currentState = input;
        }

        public boolean getCell(int x , int y) {
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
    }

    public boolean[][] checkNewGeneration(Boolean[][] input) {

        var initialBoard = new Board(input);
        Boolean nextMatrix[][] = new Boolean[initialBoard.getNumberOfRows()][initialBoard.getNumberOfColumns()];
        var newGenerationBoard = new Board(nextMatrix);

        if (initialBoard.getNumberOfRows() == 3 && initialBoard.getCell(0, 0)) {
            return new boolean[][] {
                {isCellAlive(initialBoard), false, false},
                getRow(initialBoard.getRowAtIndex(1)),
                getRow(initialBoard.getRowAtIndex(2))};
        }

        if (initialBoard.getNumberOfRows() == 3 ) {

            return new boolean[][] {
                getRow(initialBoard.getRowAtIndex(0)),
                {false, isCellAlive(initialBoard), false},
                getRow(initialBoard.getRowAtIndex(2))};
            }

        if (initialBoard.getNumberOfRows() == 2 ) {
            return new boolean[][] {
                getRow(initialBoard.getRowAtIndex(0)),
                {false, isCellAlive(initialBoard), false}};
        }

        return new boolean[][]{getRow(initialBoard.getRowAtIndex(0))};
    }

    private boolean isCellAlive(Board board) {
        int totalRowCount = getTotalRowCount(board);
        if (totalRowCount > 2
            && totalRowCount < 5) {
            return true;
        }
        return false;
    }

    private int getTotalRowCount(Board board) {
        if (board.getNumberOfRows() == 3) {
            return counterAliveNeighboursAtRow(board.getRowAtIndex(0))
                + counterAliveNeighboursAtRow(board.getRowAtIndex(1))
                + counterAliveNeighboursAtRow(board.getRowAtIndex(2));
        }
        if (board.getNumberOfRows() == 2)  {
            return counterAliveNeighboursAtRow(board.getRowAtIndex(0))
            + counterAliveNeighboursAtRow(board.getRowAtIndex(1));}

        return counterAliveNeighboursAtRow(board.getRowAtIndex(0));
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

//    private boolean[] getRowNew(Boolean[][] input) {
//        return new boolean[]{false, isCellAlive(input), false};
//    }


}
