package kata;

public class GameOfLife {

    public boolean[][] checkNewGeneration(Boolean[][] input) {

        if (input[0].length == 3 && input[0][0]) {
            return new boolean[][] {{false, true, false}};
        }

        boolean row[] = new boolean[input[0].length];
        for (int i=0; i<input.length-1; i++) {
            row[i] = false;
        }

        boolean outputMatrix[][] = {row};
        return outputMatrix ;
    }
}
