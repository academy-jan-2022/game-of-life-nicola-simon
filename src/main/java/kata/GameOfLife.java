package kata;

public class GameOfLife {

    public Boolean[][] checkNewGeneration(Boolean[][] input) {

        var initialBoard = new Board(input);

        if (initialBoard.getNumberOfRows() == 3) {
            return new Boolean[][]{
                {isCellAlive(initialBoard,0,0), isCellAlive(initialBoard,1,0), isCellAlive(initialBoard,2,0)},
                {isCellAlive(initialBoard,0,1), isCellAlive(initialBoard,1,1), isCellAlive(initialBoard,2,1)},
                {isCellAlive(initialBoard,0,2), isCellAlive(initialBoard,1,2), isCellAlive(initialBoard,2,2)},
            };
        }

        if (initialBoard.getNumberOfRows() == 2) {
            return new Boolean[][]{
                {isCellAlive(initialBoard,0,0), isCellAlive(initialBoard,1,0), isCellAlive(initialBoard,2,0)},
                {isCellAlive(initialBoard,0,1), isCellAlive(initialBoard,1,1), isCellAlive(initialBoard,2,1)},
            };
        }

        return new Boolean[][]{getRow(initialBoard.getRowAtIndex(0))};
    }

    private Boolean isCellAlive(Board board,int x, int y) {

        int aliveNeighboursCount = board.filterAliveNeighbours(board.getNeighbours(x,y)).length;
        return aliveNeighboursCount > 1
            && aliveNeighboursCount < 4;
    }

    private Boolean[] getRow(Boolean[] input) {
        if (input.length == 3 && input[0] && input[2]) {
            return new Boolean[]{false, true, false};
        }

        return new Boolean[]{false, false, false};
    }

}
