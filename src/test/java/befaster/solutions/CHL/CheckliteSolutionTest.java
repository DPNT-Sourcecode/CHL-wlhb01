package befaster.solutions.CHL;

import com.google.common.collect.Lists;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CheckliteSolutionTest {

    CheckliteSolution solution = new CheckliteSolution();

    @Test
    public void checklite_processOneItem() {
        String skus = "A";

        int totalValue = solution.checklite(skus);

        assertThat(totalValue, equalTo(50));
    }

    @Test
    public void checklite_processTwoItems() {
        String skus = "AB";

        int totalValue = solution.checklite(skus);

        assertThat(totalValue, equalTo(80));
    }

    @Test
    @Parameters(method = "dataFor_checklite_processItems")
    public void checklite_processItems(String input, int result) {
        assertThat(solution.checklite(input), equalTo(result));
    }

    @Test
    @Parameters(method = "dataFor_checklite_shouldDealWithWrongInput")
    public void checklite_shouldDealWithWrongInput(String input) {
        assertThat(solution.checklite(input), equalTo(-1));
    }

    private Object[] dataFor_checklite_processItems() {
        return new Object[]{
                new Object[]{"", 0},
                new Object[]{"DE", 55},
                new Object[]{"AAA", 130},
                new Object[]{"AAAA", 180},
                new Object[]{"ABBAAB", 205},
                new Object[]{"ABCBCAAB", 245},
                new Object[]{"ABCBCAAAB", 295},
                new Object[]{"ABCBACAAABA", 365},
                new Object[]{"AAAAAAAAAAAAABBBBEEEEE", 780}
        };
    }

    private Object[] dataFor_checklite_shouldDealWithWrongInput() {
        return new Object[] {
                new Object[]{null},
                new Object[]{"ABG"}
        };
    }
}
