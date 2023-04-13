package ingeniance.supermarche.ingenianceDemo.service;

import ingeniance.supermarche.ingenianceDemo.Dto.PriceRuleDTO;
import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.enumeration.PriceRuleType;

public interface PriceRuleService {

    PriceRuleDTO getPriceRuleById(Long id);

    PriceRuleDTO createPriceRule(PriceRuleDTO priceRuleDTO);

    void deletePriceRuleById(Long id);

    void updateType(long id, PriceRuleType newType);

    void updatePrice(long id, Float newPrice);
}
