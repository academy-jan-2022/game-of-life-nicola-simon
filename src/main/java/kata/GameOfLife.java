package kata;

import java.util.ArrayList;

public class GameOfLife {

    public Boolean[][] checkNewGeneration(Boolean[][] input) {

        var initialBoard = new Board(input);
        Boolean[][] newBoard = new Boolean[initialBoard.getNumberOfRows()][initialBoard.getNumberOfColumns()];

        for (int z = 0; z < initialBoard.getNumberOfRows(); z++){
            var newRow = new ArrayList<Boolean>();

            for (int i = 0; i < initialBoard.getNumberOfColumns(); i++){
                newRow.add(isCellAlive(initialBoard,i,z));
            }

            newBoard[z]=(
                newRow.toArray(new Boolean[0])
            );
        }

        return newBoard;

    }

    private Boolean isCellAlive(Board board,int x, int y) {

        int aliveNeighboursCount = board.filterAliveNeighbours(board.getNeighbours(x,y)).length;
        return aliveNeighboursCount > 1
            && aliveNeighboursCount < 4;
    }

}
