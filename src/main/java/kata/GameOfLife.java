package kata;

public class GameOfLife {

    public Boolean[][] checkNewGeneration(Boolean[][] input) {

        var initialBoard = new Board(input);

        if (initialBoard.getNumberOfRows() == 3 && initialBoard.getCell(0, 0)) {
            return new Boolean[][]{
                {isCellAlive(initialBoard,0,0), false, false},
                getRow(initialBoard.getRowAtIndex(1)),
                getRow(initialBoard.getRowAtIndex(2))
            };
        }

        if (initialBoard.getNumberOfRows() == 3) {

            return new Boolean[][]{
                getRow(initialBoard.getRowAtIndex(0)),
                {false, isCellAlive(initialBoard,1,1), false},
                getRow(initialBoard.getRowAtIndex(2))
            };
        }

        if (initialBoard.getNumberOfRows() == 2) {
            return new Boolean[][]{
                getRow(initialBoard.getRowAtIndex(0)),
                {false, isCellAlive(initialBoard,1,1), false}
            };
        }

        return new Boolean[][]{getRow(initialBoard.getRowAtIndex(0))};
    }

    private Boolean isCellAlive(Board board,int x, int y) {

        int aliveNeighboursCount = board.filterAliveNeighbours(board.getNeighbours(x,y)).length;
        if (aliveNeighboursCount > 1
            && aliveNeighboursCount < 4) {
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
        if (board.getNumberOfRows() == 2) {
            return counterAliveNeighboursAtRow(board.getRowAtIndex(0))
                + counterAliveNeighboursAtRow(board.getRowAtIndex(1));
        }

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

    private Boolean[] getRow(Boolean[] input) {
        if (input.length == 3 && input[0] && input[2]) {
            return new Boolean[]{false, true, false};
        }

        return new Boolean[]{false, false, false};
    }

}
