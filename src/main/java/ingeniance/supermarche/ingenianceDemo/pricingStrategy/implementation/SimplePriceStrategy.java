package ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.PricingStrategy;

/**
 * This class implements the PricingStrategy interface for simple pricing rule.
 * The simple pricing rule just multiplies the simple price by the quantity.
 */

public class SimplePriceStrategy implements PricingStrategy {

    @Override
    public float calculatePrice(PriceRule priceRule, float quantity) {
        return priceRule.getSimplePrice() * quantity;
    }
}
