package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CheckliteSolution {

    private static final Map<Character, Integer> PRICES_PER_SKU = loadPrices();
    private static final Map<Character, Integer> BUNDLE_FOR_SKU = loadBundles();
    private static final Map<String, Integer> PRICES_PER_BUNDLE = loadPricesPerBundle();

    private static final Pattern ALLOWED_SKU = Pattern.compile("[ABCDE]+|^$");

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
        for (Map.Entry<Character, Integer> skuEntry : occurrencesPerSKU.entrySet()) {
            int numberOfItems = skuEntry.getValue();
            if(BUNDLE_FOR_SKU.containsKey(skuEntry.getKey()) &&
                    PRICES_PER_BUNDLE.containsKey(getBundlePriceKey(skuEntry))) {
                int pricePerBundle = PRICES_PER_BUNDLE.get(getBundlePriceKey(skuEntry));
                while (numberOfItems >= BUNDLE_FOR_SKU.get(skuEntry.getKey())) {
                    result += pricePerBundle;
                    numberOfItems -= BUNDLE_FOR_SKU.get(skuEntry.getKey());
                }
            }
            if(numberOfItems > 0) {
                result += (numberOfItems * PRICES_PER_SKU.get(skuEntry.getKey()));
            }
        }
        return result;
    }

    private static Map<Character, Integer> loadPrices() {
        Map<Character, Integer> prices = new HashMap<>();
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);
        prices.put('E', 40);
        return prices;
    }
    private static Map<Character, Integer> loadBundles() {
        Map<Character, Integer> bundles = new HashMap<>();
        bundles.put('A', 3);
        bundles.put('A', 5);
        bundles.put('B', 2);
        bundles.put('E', 3);
        return bundles;
    }

    private static Map<String, Integer> loadPricesPerBundle() {
        Map<String, Integer> pricesPerBundle = new HashMap<>();
        pricesPerBundle.put("3A", 130);
        pricesPerBundle.put("5A", 200);
        pricesPerBundle.put("2B", 45);
        pricesPerBundle.put("3E", 80);
        return pricesPerBundle;
    }

    private boolean isValidInput(String skus) {
        return skus != null && ALLOWED_SKU.matcher(skus).matches();
    }

    private String getBundlePriceKey(Map.Entry<Character, Integer> skuEntry) {
        return BUNDLE_FOR_SKU.get(skuEntry.getKey()) + "" + skuEntry.getKey();
    }
}


