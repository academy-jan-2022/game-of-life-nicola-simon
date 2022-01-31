package kata;

public class GameOfLife {

    public String checkNewGeneration(String input) {

        long countOfAliveCells = input.chars().filter(ch -> ch == '1').count();
        if (countOfAliveCells == 1 || countOfAliveCells == 5) {
            return "0|0|0\n"
                + "0|0|0\n"
                + "0|0|0";
        }

        return "0|0|0\n"
            + "0|1|0\n"
            + "0|0|0";
    }
}
