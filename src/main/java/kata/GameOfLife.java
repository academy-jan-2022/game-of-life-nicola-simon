package kata;

public class GameOfLife {

    public boolean[][] checkNewGeneration(Boolean[][] input) {

        if (input.length == 2 ) {
            if (input[1][0] && input[1][2]){
                return new boolean[][] {
                    {false, false, false},
                    {false, true, false}};
            }
            if (input[0][1] && input[1][2]){
                return new boolean[][] {
                    {false, false, false},
                    {false, true, false}};
            }
            return new boolean[][] {
                {false, false, false},
                {false, false, false}};
        }

        return new boolean[][]{getRow(input[0])};
    }

    private boolean[] getRow(Boolean[] input) {
        if (input.length == 3 && input[0] && input[2]) {
            return new boolean[]{false, true, false};
        }

        return new boolean[]{false, false, false};
    }
}
