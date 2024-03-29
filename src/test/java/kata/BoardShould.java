package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardShould {


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
        assertFalse(neighbours[0]);
    }

    @Test void
    return_a_correct_neighbour_state_for_two_cells() {
        Boolean[][] currentMatrix = {{false, true}};
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(0, 0);
        assertEquals(1, neighbours.length);
        assertTrue(neighbours[0]);
    }

    @Test void
    return_a_correct_neighbour_state_for_right_cell_when_given_two_cells() {
        Boolean[][] currentMatrix = {{false, true}};
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(1, 0);
        assertEquals(1, neighbours.length);
        assertFalse(neighbours[0]);
    }

    @Test void
    return_two_correct_neighbours_state_for_middle_cell_given_three_cells() {
        Boolean[][] currentMatrix = {{true, false, true}};
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(1, 0);
        assertEquals(2, neighbours.length);
        assertTrue(neighbours[0]);
        assertTrue(neighbours[1]);
    }

    @Test void
    return_one_correct_neighbour_for_bottom_cell_given_one_top_row_cell(){
        Boolean[][] currentMatrix = {
            {true},
            {false}
        };
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(0,1);
        assertEquals(1, neighbours.length);
        assertTrue(neighbours[0]);
    }

    @Test void
    return_one_correct_neighbour_for_top_cell_given_one_bottom_row_cell(){
        Boolean[][] currentMatrix = {
            {true},
            {false}
        };
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(0,0);
        assertEquals(1, neighbours.length);
        assertFalse(neighbours[0]);
    }

    @Test void
    return_one_correct_neighbour_for_bottom_right_cell_given_2_by_2_grid(){
        Boolean[][] currentMatrix = {
            {true, false},
            {false, false}
        };
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(1,1);
        var aliveNeighbours = board.filterAliveNeighbours(neighbours);
        assertEquals(3, neighbours.length);
        assertEquals(1, aliveNeighbours.length);
        assertTrue(aliveNeighbours[0]);
    }

    @Test void
    return_one_correct_neighbour_for_top_left_cell_given_2_by_2_grid(){
        Boolean[][] currentMatrix = {
            {false, false},
            {false, true}
        };
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(0,0);
        var aliveNeighbours = board.filterAliveNeighbours(neighbours);
        assertEquals(3, neighbours.length);
        assertEquals(1, aliveNeighbours.length);
        assertTrue(aliveNeighbours[0]);
    }

    @Test void
    return_one_correct_neighbour_for_bottom_left_cell_given_2_by_2_grid(){
        Boolean[][] currentMatrix = {
            {false, true},
            {false, false}
        };
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(0,1);
        var aliveNeighbours = board.filterAliveNeighbours(neighbours);
        assertEquals(3, neighbours.length);
        assertEquals(1, aliveNeighbours.length);
        assertTrue(aliveNeighbours[0]);
    }

    @Test void
    return_one_correct_neighbour_for_top_right_cell_given_2_by_2_grid(){
        Boolean[][] currentMatrix = {
            {false, false},
            {true, false}
        };
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(1,0);
        var aliveNeighbours = board.filterAliveNeighbours(neighbours);
        assertEquals(3, neighbours.length);
        assertEquals(1, aliveNeighbours.length);
        assertTrue(aliveNeighbours[0]);
    }

    @Test void
    return_eight_correct_neighbour_for_middle_cell_given_3_by_3_grid(){
        Boolean[][] currentMatrix = {
            {true, true, false},
            {true, false, true},
            {true, false, true}
        };
        var board = new Board(currentMatrix);
        var neighbours = board.getNeighbours(1,1);
        var aliveNeighbours = board.filterAliveNeighbours(neighbours);
        assertEquals(8, neighbours.length);
        assertEquals(6, aliveNeighbours.length);
        assertTrue(aliveNeighbours[0]);
    }

}
