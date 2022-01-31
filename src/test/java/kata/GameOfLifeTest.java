package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void return_empty_matrix_given_only_one_live_cell()
    {
        var gameOfLife = new GameOfLife();
         var result = gameOfLife.checkNewGeneration("1");

        assertEquals(result, "0");
    }

}
