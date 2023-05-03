package ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.PricingStrategy;

/**
 *  * This class implements the PricingStrategy interface for buy X get Y free pricing rule.
 *  * The buy 2 get 1 free pricing rule applies a special price for every certain number of items (including some for free), and normal price for the remainder.
 */
public class BuyTwoGetOneFree  implements PricingStrategy {

    @Override
    public float calculatePrice(PriceRule priceRule, float quantity) {
        int itemCountInBundle = 3;
        int numberOfBundles = (int) (quantity / itemCountInBundle);
        int remainingItems = (int) (quantity % itemCountInBundle);
        return( numberOfBundles * 2 + remainingItems ) * priceRule.getSimplePrice();
    }
}
