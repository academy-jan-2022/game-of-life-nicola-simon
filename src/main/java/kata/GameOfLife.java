package kata;

public class GameOfLife {

    Board initialBoard;


    public Boolean[][] checkNewGeneration(Boolean[][] input) {

        initialBoard = new Board(input);
        Boolean[][] newBoard = new Boolean[initialBoard.getNumberOfRows()][initialBoard.getNumberOfColumns()];

        for (int z = 0; z < initialBoard.getNumberOfRows(); z++){
            rowConstructor(newBoard, z);
        }

        return newBoard;

    }

    private void rowConstructor( Boolean[][] newBoard, int z) {
        for (int i = 0; i < initialBoard.getNumberOfColumns(); i++){
            newBoard[z][i]=(isCellAlive(initialBoard,i, z));
        }
    }

    private Boolean isCellAlive(Board board,int x, int y) {

        int aliveNeighboursCount = board.filterAliveNeighbours(board.getNeighbours(x,y)).length;

        if (board.getCell(x,y)){
            return aliveNeighboursCount == 2
                || aliveNeighboursCount == 3;
        }
        return aliveNeighboursCount == 3;
    }

}
