package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void kepp_middle_cell_alive_with_two_neighbours()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {{true, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[0][1]);
    }

}
