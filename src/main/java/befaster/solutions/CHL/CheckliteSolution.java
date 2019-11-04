package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {

    private final static Map<String, Integer> pricesPerSKU = loadPrices();

    public Integer checklite(String skus) {
        return pricesPerSKU.get(skus);
    }

    /*
     +------+-------+----------------+
    | Item | Price | Special offers |
    +------+-------+----------------+
    | A    | 50    | 3A for 130     |
    | B    | 30    | 2B for 45      |
    | C    | 20    |                |
    | D    | 15    |                |
    +------+-------+----------------+
    */
    private static Map<String, Integer> loadPrices() {
        Map<String, Integer> prices = new HashMap<>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("D", 15);
        return prices;
    }
}

