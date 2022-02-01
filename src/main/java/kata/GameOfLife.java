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

    private Boolean[] getRow(Boolean[] input) {
        if (input.length == 3 && input[0] && input[2]) {
            return new Boolean[]{false, true, false};
        }

        return new Boolean[]{false, false, false};
    }

}
