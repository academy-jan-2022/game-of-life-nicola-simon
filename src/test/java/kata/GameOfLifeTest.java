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
    void keep_middle_cell_alive_with_two_neighbours()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {{true, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[0][1]);
    }

    @Test
    void kill_all_cells_given_only_two_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {{false, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[0][1]);
    }

    @Test
    void kill_all_cells_given_only_two_neighbours_alive_part_2()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {{true, true, false}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[0][1]);
    }

    @Test
    void keep_alive_middle_cell_at_second_row_given_two_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, false, false},
            {true, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }

    @Test
    void kill_middle_cell_at_second_row_given_two_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, false, false},
            {false, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[1][1]);
    }

    @Test
    void keep_alive_middle_cell_at_second_row_given_top_and_right_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, true, false},
            {false, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }
    @Test
    void keep_alive_middle_cell_at_second_row_given_left_corner_and_right_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {true, false, false},
            {false, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }
}
