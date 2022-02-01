package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameOfLifeTest {

    @Test
    void kill_all_cells_given_only_one_cell_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean currentMatrix [][] = {{true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[0][0]);
    }

    @Test
    void kill_all_cells_given_two_cells_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean currentMatrix [][] = {{true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[0][1]);
    }

}
