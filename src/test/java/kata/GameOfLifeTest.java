package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameOfLifeTest {

    @Test
    void return_empty_matrix_given_corners_only()
    {
        var gameOfLife = new GameOfLife();
        Boolean currentMatrix [][] = {{true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[0][0]);
    }

}
