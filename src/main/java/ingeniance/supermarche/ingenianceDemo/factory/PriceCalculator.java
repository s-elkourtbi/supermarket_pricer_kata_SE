package ingeniance.supermarche.ingenianceDemo.factory;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.PricingStrategy;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation.BuyTwoGetOneFree;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation.PerPoundPrice;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation.SimplePriceStrategy;
import ingeniance.supermarche.ingenianceDemo.pricingStrategy.implementation.ThreForDollar;

/**
 * Contain the logic to calculate the price depending on price rule applied
 * to the product
 */
public class PriceCalculator {

    /**
     *
     * @param priceRule
     * @param quantity
     * @return final price
     */
    public static Float calculateFinalPrice(PriceRule priceRule, float quantity) {
        PricingStrategy strategy;
        // Depending on the type of the price rule, assign the appropriate pricing strategy
        switch (priceRule.getType()) {
            case SIMPLE:
                strategy = new SimplePriceStrategy();
                break;

            case THREE_FOR_DOLLAR:
                strategy = new ThreForDollar();
                break;

            case PER_POUND:
                strategy = new PerPoundPrice();
                break;

            case BUY_TWO_GET_ONE_FREE:
                strategy = new BuyTwoGetOneFree();
                break;

            default:
                throw new IllegalArgumentException("Unsupported price rule type");
        }
        return strategy.calculatePrice(priceRule, quantity);
    }
}
