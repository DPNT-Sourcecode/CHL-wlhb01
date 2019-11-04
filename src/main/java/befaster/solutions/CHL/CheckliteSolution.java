package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CheckliteSolution {

    private static final Map<Character, Integer> pricesPerSKU = loadPrices();
    private static final Pattern ALLOWED_SKU = Pattern.compile("[ABCD]+");

    public Integer checklite(String skus) {
        if(!isValidInput(skus)) {
            return -1;
        }

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

    private boolean isValidInput(String skus) {
        return skus != null && ALLOWED_SKU.matcher(skus).matches();
    }
}

