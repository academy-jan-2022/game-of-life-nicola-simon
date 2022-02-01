package kata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class BoardShould {
    @Test void
    return_that_an_isolated_living_cell_dies() {
        Boolean[][] currentMatrix = {
            {true}
        };
        var board = new Board(currentMatrix);
        var willBeAlive = board.willBeAlive(0, 0);
        assertFalse(willBeAlive);
    }
}
