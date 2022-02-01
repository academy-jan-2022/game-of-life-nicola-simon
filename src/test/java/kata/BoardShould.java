package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardShould {
    @Test void
    return_that_an_isolated_dead_cell_stays_dead_in_single_cell_matrix() {
        Boolean[][] currentMatrix = {
            {false}
        };
        var board = new Board(currentMatrix);
        var willBeAlive = board.willBeAlive(0, 0);
        assertFalse(willBeAlive);
    }

    @Test void
    return_that_a_cell_in_population_stays_alive() {
        Boolean[][] currentMatrix = {
            {true, true, true}
        };
        var board = new Board(currentMatrix);
        var willBeAlive = board.willBeAlive(0, 1);
        assertTrue(willBeAlive);
    }

    @Test void
    return_that_a_cell_without_population_dies() {
        Boolean[][] currentMatrix = {
            {false, true, false}
        };
        var board = new Board(currentMatrix);
        var willBeAlive = board.willBeAlive(0, 1);
        assertFalse(willBeAlive);
    }

    @Test void
    return_that_a_cell_with_population_below_stays_alive() {
        Boolean[][] currentMatrix = {
            {false, true, false},
            {true, true, false},
        };
        var board = new Board(currentMatrix);
        var willBeAlive = board.willBeAlive(0, 1);
        assertTrue(willBeAlive);
    }

    @Test void
    return_no_neighbours_for_single_cell() {
        Boolean[][] currentMatrix = {{false}};
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(0, 0);
        assertEquals(0, neighbours.length);

    }

    @Test void
    return_one_neighbour_for_two_cell() {
        Boolean[][] currentMatrix = {{false, false}};
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(0, 0);
        assertEquals(1, neighbours.length);

    }
}
