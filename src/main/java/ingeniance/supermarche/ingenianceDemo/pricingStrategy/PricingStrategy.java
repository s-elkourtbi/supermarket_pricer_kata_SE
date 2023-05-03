package ingeniance.supermarche.ingenianceDemo.pricingStrategy;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;

/**
 * Interface for the pricing strategies. This will be implemented by different pricing strategies.
 */
public interface PricingStrategy {

    float calculatePrice(PriceRule priceRule, float quantity);
}
