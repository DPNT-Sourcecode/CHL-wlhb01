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
    public void compute_sum() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "dataFor_compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException")
    public void compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException(int x, int y) {
        sum.compute(x, y);
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

