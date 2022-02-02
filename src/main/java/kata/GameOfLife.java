package kata;

public class GameOfLife {

    Board initialBoard;

    public Boolean[][] checkNewGeneration(Boolean[][] input) {

        initialBoard = new Board(input);
        Boolean[][] newBoard = new Boolean[initialBoard.getNumberOfRows()][initialBoard.getNumberOfColumns()];

        for (int rowIndex = 0; rowIndex < initialBoard.getNumberOfRows(); rowIndex++){
            rowConstructor(newBoard, rowIndex);
        }

        return newBoard;
    }

    private void rowConstructor( Boolean[][] newBoard, int rowNumber) {
        for (int columnIndex = 0; columnIndex < initialBoard.getNumberOfColumns(); columnIndex++){
            newBoard[rowNumber][columnIndex]=(willCellBeAlive(columnIndex, rowNumber));
        }
    }

    private Boolean willCellBeAlive(int x, int y) {

        int aliveNeighboursCount = initialBoard.filterAliveNeighbours(initialBoard.getNeighbours(x,y)).length;

        if (initialBoard.getCell(x,y)){
            return aliveNeighboursCount == 2
                || aliveNeighboursCount == 3;
        }
        return aliveNeighboursCount == 3;
    }

}
