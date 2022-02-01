package kata;

import java.util.ArrayList;

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

        var foo = new ArrayList<Boolean>();

        for (int i = 0; i < initialBoard.getNumberOfColumns(); i++){
            foo.add(isCellAlive(initialBoard,i,0));
        }

        return new Boolean[][]{
            foo.toArray(new Boolean[0])
        };

    }

    private Boolean isCellAlive(Board board,int x, int y) {

        int aliveNeighboursCount = board.filterAliveNeighbours(board.getNeighbours(x,y)).length;
        return aliveNeighboursCount > 1
            && aliveNeighboursCount < 4;
    }

}
