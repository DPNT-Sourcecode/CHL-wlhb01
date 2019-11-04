package befaster.solutions.SUM;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        if(!isInputValid(x) || !isInputValid(y)) {
            throw new IllegalArgumentException();
        }
        return x + y;
    }

    private boolean isInputValid(int input) {
        return input >= 0 && input <= 100;
    }
}

