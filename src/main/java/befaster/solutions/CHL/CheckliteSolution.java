package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckliteSolution {

    private static final Map<Character, Integer> PRICES_PER_SKU = loadPrices();
    private static final Map<Character, Integer> BUNDLE_FOR_SKU = loadBundles();
    private static final Map<String, Integer> PRICES_PER_BUNDLE = loadPricesPerBundle();

    private static final Pattern ALLOWED_SKU = Pattern.compile("[ABCD]+");

    public Integer checklite(String skus) {
        if (!isValidInput(skus)) {
            return -1;
        }

        char[] allSKUs = skus.toCharArray();

        Map<Character, Integer> occurrencesPerSKU = new HashMap<>();

        for (char sku : allSKUs) {
            if(occurrencesPerSKU.containsKey(sku)) {
                occurrencesPerSKU.put(sku, occurrencesPerSKU.get(sku) + 1);
            } else {
                occurrencesPerSKU.put(sku, 1);
            }
        }

        int result = 0;
        for (char sku : allSKUs) {
            int numberOfItems = occurrencesPerSKU.get(sku);
            if(BUNDLE_FOR_SKU.containsKey(sku) &&
                    PRICES_PER_BUNDLE.containsKey(BUNDLE_FOR_SKU.get(sku) + "" + sku)) {
                int pricePerBundle = PRICES_PER_BUNDLE.get(BUNDLE_FOR_SKU.get(sku) + "" + sku);
                while (numberOfItems % BUNDLE_FOR_SKU.get(sku) == 0) {
                    result += pricePerBundle;
                    numberOfItems -= BUNDLE_FOR_SKU.get(sku);
                }
            }
            result += (numberOfItems * PRICES_PER_SKU.get(sku));

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

    private static Map<String, Integer> loadPricesPerBundle() {
        Map<String, Integer> pricesPerBundle = new HashMap<>();
        pricesPerBundle.put("3A", 130);
        pricesPerBundle.put("2B", 45);
        return pricesPerBundle;
    }

    private boolean isValidInput(String skus) {
        return skus != null && ALLOWED_SKU.matcher(skus).matches();
    }
}




