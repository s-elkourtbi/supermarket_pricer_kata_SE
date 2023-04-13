package ingeniance.supermarche.ingenianceDemo.factory;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;

public class PriceCalculator {
    public static Float calculateFinalPrice(PriceRule priceRule, float quantity) {
        float finalPrice;

        switch (priceRule.getType()) {
            case SIMPLE:
                finalPrice = priceRule.getSimplePrice() * quantity;
                break;

            case THREE_FOR_DOLLAR:
                int itemNumberforOneDollar = 3;
                int numberOfBundlesForOneDollar = (int) (quantity / itemNumberforOneDollar);
                int remainingItemsForOneDollar = (int) (quantity % itemNumberforOneDollar);
                finalPrice = numberOfBundlesForOneDollar + remainingItemsForOneDollar * priceRule.getSimplePrice();
                break;

            case PER_POUND:
                finalPrice = (quantity / 16) * priceRule.getSimplePrice();
                break;

            case BUY_TWO_GET_ONE_FREE:
                int itemCountInBundle = 3;
                int numberOfBundles = (int) (quantity / itemCountInBundle);
                int remainingItems = (int) (quantity % itemCountInBundle);
                finalPrice = ( numberOfBundles * 2 + remainingItems ) * priceRule.getSimplePrice();
                break;

            default:
                throw new IllegalArgumentException("Unsupported price rule type");
        }

        return finalPrice;
    }
}
