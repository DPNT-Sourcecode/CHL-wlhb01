package befaster.solutions.SUM;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
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
    @Parameterized.Parameters(method = "")
    public void compute_argumentOutOfLimitsShouldThrowAnIllegalArgumentException() {
        sum.compute(-1, 2);
    }


    private Iterable<Object[]>

}



