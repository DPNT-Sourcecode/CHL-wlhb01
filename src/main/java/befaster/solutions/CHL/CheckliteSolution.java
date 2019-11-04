package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CheckliteSolution {

    private final static Map<Character, Integer> pricesPerSKU = loadPrices();

    public Integer checklite(String skus) {
        validateInput(skus);
        char[] allSKUs = skus.toCharArray();
        return pricesPerSKU.get(allSKUs[0]) + pricesPerSKU.get(allSKUs[1]);
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

    private static Map<Character, Integer> loadPrices() {
        Map<Character, Integer> prices = new HashMap<>();
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);
        return prices;
    }

    private boolean validateInput(String skus) {
        return Pattern.compile("[ABCD]]").matcher(skus).matches();
    }
}
