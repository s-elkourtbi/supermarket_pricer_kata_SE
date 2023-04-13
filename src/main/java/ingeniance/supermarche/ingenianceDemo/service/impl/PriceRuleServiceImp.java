package ingeniance.supermarche.ingenianceDemo.service.impl;

import ingeniance.supermarche.ingenianceDemo.Dto.PriceRuleDTO;
import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.enumeration.PriceRuleType;
import ingeniance.supermarche.ingenianceDemo.mapper.SupermarketMapper;
import ingeniance.supermarche.ingenianceDemo.repository.PriceRuleRepository;
import ingeniance.supermarche.ingenianceDemo.service.PriceRuleService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceRuleServiceImp implements PriceRuleService {

    @Autowired
    PriceRuleRepository priceRuleRepository;

    SupermarketMapper supermarketMapper = Mappers.getMapper(SupermarketMapper.class);



    public PriceRuleDTO getPriceRuleById(Long id) {
        return supermarketMapper.priceRuletoDTO(priceRuleRepository.findById(id).get());
    }

    public PriceRuleDTO createPriceRule(PriceRuleDTO priceRuleDTO) {
        PriceRule priceRule = supermarketMapper.priceRuleDtoToEntity(priceRuleDTO);
        return supermarketMapper.priceRuletoDTO(priceRuleRepository.save(priceRule));
    }

    public void deletePriceRuleById(Long id) {
        priceRuleRepository.deleteById(id);
    }

    public void updatePrice(long id, Float newPrice){
        priceRuleRepository.updatePrice(id, newPrice);
    }

    public void updateType(long id, PriceRuleType newType){
        priceRuleRepository.updateType(id, newType);
    }
}
