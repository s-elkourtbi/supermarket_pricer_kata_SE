package ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.PricingStrategy;

public class ThreForDollar implements PricingStrategy {

    @Override
    public float calculatePrice(PriceRule priceRule, float quantity) {
        int itemNumberforOneDollar = 3;
        int numberOfBundlesForOneDollar = (int) (quantity / itemNumberforOneDollar);
        int remainingItemsForOneDollar = (int) (quantity % itemNumberforOneDollar);
        return numberOfBundlesForOneDollar + remainingItemsForOneDollar * priceRule.getSimplePrice();
    }
}
