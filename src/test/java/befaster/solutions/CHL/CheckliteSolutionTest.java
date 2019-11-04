package befaster.solutions.CHL;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    @Parameters(method = "dataFor_checklite_shouldDealWithWrongInput")
    public void checklite_shouldDealWithWrongInput(String input) {
        assertThat(solution.checklite(input), equalTo(-1));
    }

    private Object[] dataFor_checklite_shouldDealWithWrongInput() {
        return new Object[] {
                new Object[]{""},
                new Object[]{null},
                new Object[]{"ABG"}
        };
    }
}