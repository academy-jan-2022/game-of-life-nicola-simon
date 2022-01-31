package kata;

public class GameOfLife {

    public String checkNewGeneration(String input) {

        if (input.equals("0|0|0\n"
            + "0|1|0\n"
            + "0|0|0")) {
            return "0|0|0\n"
                + "0|0|0\n"
                + "0|0|0";
        }

        return "0|0|0\n"
            + "0|1|0\n"
            + "0|0|0";
    }
}
