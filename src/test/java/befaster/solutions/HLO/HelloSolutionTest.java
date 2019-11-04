package befaster.solutions.HLO;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class HelloSolutionTest {

    private HelloSolution solution = new HelloSolution();

    @Test
    public void hello_shouldReturnHello() {
        assertThat(solution.hello(""), equalTo("hello"));
    }
}