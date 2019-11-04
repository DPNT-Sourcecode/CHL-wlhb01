package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CheckliteSolution {

    private static final Map<Character, Integer> PRICES_PER_SKU = loadPrices();
    private static final Map<Character, Integer> BUNDLE_FOR_SKU = loadBundles();
    private static final Map<Character, Integer> PRICES_PER_BUNDLE = loadPricesPerBundle();

    private static final Pattern ALLOWED_SKU = Pattern.compile("[ABCD]+");

    public Integer checklite(String skus) {
        if (!isValidInput(skus)) {
            return -1;
        }

        char[] allSKUs = skus.toCharArray();

        int result = 0;
        for (char sku : allSKUs) {
            result += PRICES_PER_SKU.get(sku);
        }
        return result;
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

    private static Map<Character, Integer> loadBundles() {
        Map<Character, Integer> bundles = new HashMap<>();
        bundles.put('A', 3);
        bundles.put('B', 2);
        return bundles;
    }

    private boolean isValidInput(String skus) {
        return skus != null && ALLOWED_SKU.matcher(skus).matches();
    }
}







