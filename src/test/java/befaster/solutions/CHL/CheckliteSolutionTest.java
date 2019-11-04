package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

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
}