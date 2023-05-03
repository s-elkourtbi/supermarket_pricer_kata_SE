package ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.PricingStrategy;

/**
 * This class implements the PricingStrategy interface for weight pricing rule.
 * The weight pricing rule calculates the price based on weight, assuming the price is per pound and the quantity is in ounces.
 */

public class PerPoundPrice implements PricingStrategy {

    @Override
    public float calculatePrice(PriceRule priceRule, float quantity) {
        return (quantity / 16) * priceRule.getSimplePrice(); // assuming quantity is in ounces and price is per pound
    }
}
