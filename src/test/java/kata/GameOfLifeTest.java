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

    @Test
    void keep_alive_middle_cell_at_second_row_given_right_corner_and_right_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, false, true},
            {false, true, true}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }

    @Test
    void keep_alive_middle_cell_at_second_row_given_right_corner_and_left_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, false, true},
            {true, true, false}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }

    @Test
    void keep_alive_middle_cell_at_second_row_given_left_corner_and_left_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {true, false, false},
            {true, true, false}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }

    @Test
    void keep_alive_second_row_middle_cell_given_top_left_and_top_right_neighbours()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {true, false, true},
            {false, true, false}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }

    @Test
    void kill_second_row_middle_cell_given_all_top_row_and_left_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {true, true, true},
            {true, true, false}};
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[1][1]);
    }

    @Test
    void keep_middle_cell_alive_with_bottom_left_and_bottom_right_neighbour()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, false, false},
            {false, true, false},
            {true, false, true}
        };
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }

    @Test
    void kill_second_row_middle_cell_given_all_bottom_row_and_left_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, false, false},
            {true, true, false},
            {true, true, true}
        };
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[1][1]);
    }

    @Test
    void resurrect_second_row_middle_cell_given_all_bottom_row_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, false, false},
            {false, false, false},
            {true, true, true}
        };
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);
    }

    @Test
    void keep_alive_first_row_left_cell_given_middle_left_and_middle_top_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {true, true, false},
            {true, false, false},
            {false, false, false}
        };
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[0][0]);
    }

    @Test
    void keep_alive_first_row_right_cell_given_middle_right_and_middle_top_neighbours_alive()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {false, true, true},
            {false, false, true},
            {false, false, false}
        };
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[0][2]);
    }

    @Test
    void check_cell_comes_to_life_with_three_live_neighbours()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {true, true},
            {true, false},
        };
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertTrue( result[1][1]);

    }

    @Test
    void check_cell_stays_dead_with_two_live_neighbours()
    {
        var gameOfLife = new GameOfLife();
        Boolean[][] currentMatrix = {
            {true, false},
            {true, false},
        };
        var result = gameOfLife.checkNewGeneration(currentMatrix);

        assertFalse( result[1][1]);

    }

}
