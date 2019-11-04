package befaster.solutions.SUM;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JUnitParamsRunner.class)
public class SumSolutionTest {
    private SumSolution sum;

    @Before
    public void setUp() {

        sum = new SumSolution();
    }

    @Test
    @Parameters(method = "dataFor_compute_sum")
    public void compute_sum(int x, int y, int result) {
        assertThat(sum.compute(x, y), equalTo(result));
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "dataFor_compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException")
    public void compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException(int x, int y) {
        sum.compute(x, y);
    }

    private Object[] dataFor_compute_sum() {
        return new Object[]{
                new Object[]{1, 1, 2},
                new Object[]{50, 0, 50},
                new Object[]{0, 50, 50}
        };
    }

    private Object[] dataFor_compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException() {
        return new Object[]{
                new Object[]{-1, 1},
                new Object[]{1, -1},
                new Object[]{-1, -1},
                new Object[]{101, 1},
                new Object[]{1, 101},
                new Object[]{101, 101}
        };
    }

}
