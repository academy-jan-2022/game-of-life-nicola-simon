package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void return_empty_matrix_given_only_one_live_cell()
    {
        var gameOfLife = new GameOfLife();
         var result = gameOfLife.checkNewGeneration(
             "0|0|0\n"
             + "0|1|0\n"
             + "0|0|0");

        assertEquals("0|0|0\n"
            + "0|0|0\n"
            + "0|0|0", result);
    }

    @Test
    void return_only_middle_cell_alive_given_cells_in_one_diagonal()
    {
        var gameOfLife = new GameOfLife();
        var result = gameOfLife.checkNewGeneration(
            "1|0|0\n"
                + "0|1|0\n"
                + "0|0|1"

        );

        assertEquals(
            "0|0|0\n"
                + "0|1|0\n"
                + "0|0|0", result);
    }

    @Test
    void return_only_middle_cell_alive_given_cells_in_reverse_diagonal()
    {
        var gameOfLife = new GameOfLife();
        var result = gameOfLife.checkNewGeneration(
            "0|0|1\n"
                + "0|1|0\n"
                + "1|0|0"

        );

        assertEquals(
            "0|0|0\n"
                + "0|1|0\n"
                + "0|0|0", result);
    }

    @Test
    void return_only_middle_cell_alive_given_cells_in_middle_row()
    {
        var gameOfLife = new GameOfLife();
        var result = gameOfLife.checkNewGeneration(
            "0|0|0\n"
                + "1|1|1\n"
                + "0|0|0"

        );

        assertEquals(
            "0|0|0\n"
                + "0|1|0\n"
                + "0|0|0", result);
    }

    @Test
    void return_empty_matrix_given_middle_and_corners_cells()
    {
        var gameOfLife = new GameOfLife();
        var result = gameOfLife.checkNewGeneration(
            "1|0|1\n"
                + "0|1|0\n"
                + "1|0|1"

        );

        assertEquals(
            "0|0|0\n"
                + "0|0|0\n"
                + "0|0|0", result);
    }

}
