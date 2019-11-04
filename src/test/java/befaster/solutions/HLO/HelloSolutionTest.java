package befaster.solutions.HLO;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class HelloSolutionTest {

    private HelloSolution solution = new HelloSolution();

    @Test
    @Parameters(method = "dataFor_hello_shouldReturnHello")
    public void hello_shouldReturnHello(String name, String expectedOutput) {
        assertThat(solution.hello(name), equalTo(expectedOutput));
    }

    private Object[] dataFor_hello_shouldReturnHello() {
        return new Object[]{
                new Object[]{"John", "Hello, John!"},
                new Object[]{"Mary", "Hello, Mary!"}
        };
    }
}