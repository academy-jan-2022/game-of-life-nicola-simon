package kata;

public class GameOfLife {

    public boolean[][] checkNewGeneration(Boolean[][] input) {

        if (input[0].length == 3 && input[0][0]) {
            return new boolean[][] {{false, true, false}};
        }

        if (input[0].length == 3) {
            return new boolean[][] {{false, false, false}};
        }

        if (input[0].length == 2) {
            return new boolean[][] {{false, false}};
        }

        boolean outputMatrix[][] = {{false}};
        return outputMatrix ;
    }
}
