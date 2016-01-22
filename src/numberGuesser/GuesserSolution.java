package numberguesser;

/**
 * Created by Iryna Guzenko on 22.01.2016.
 */
public class GuesserSolution {
    private int secretNumber;

    public GuesserSolution(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getNumber() {
        int i = 500;
        for (int k = 0; k < 10; k++) {
            switch (guess(i)) {
                case "Too high!":
                    i = i - i / 2;
                    break;
                case "Too low!":
                    i = i + i / 2;
                    break;
                case "Correct!":
                    return i;
            }
        }
        return i;
    }

    private String guess(int a) {
        if (a > secretNumber) return "Too high!";
        if (a < secretNumber) return "Too low!";
        return "Correct";
    }
}
