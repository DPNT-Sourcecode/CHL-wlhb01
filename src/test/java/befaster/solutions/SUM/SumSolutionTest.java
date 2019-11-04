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
    public void compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException() {
        sum.compute(-1, 2);
    }

    private Iterable<Object[]> dataFor_compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException

}
