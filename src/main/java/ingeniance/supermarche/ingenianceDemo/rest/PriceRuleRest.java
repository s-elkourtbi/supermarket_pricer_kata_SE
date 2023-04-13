package ingeniance.supermarche.ingenianceDemo.rest;

import ingeniance.supermarche.ingenianceDemo.Dto.PriceRuleDTO;
import ingeniance.supermarche.ingenianceDemo.enumeration.PriceRuleType;
import ingeniance.supermarche.ingenianceDemo.mapper.SupermarketMapper;
import ingeniance.supermarche.ingenianceDemo.service.PriceRuleService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
public class PriceRuleRest {

    @Autowired
    PriceRuleService priceRuleService;

    SupermarketMapper supermarketMapper = Mappers.getMapper(SupermarketMapper.class);


    @RequestMapping(value = "/getPriceRule/{id}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity< PriceRuleDTO> getPriceRuleById(@PathVariable Long id) {
        PriceRuleDTO priceRuleDTO = priceRuleService.getPriceRuleById(id);
        return new ResponseEntity<>(priceRuleDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/newPriceRule", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<PriceRuleDTO> createPriceRule(@RequestBody PriceRuleDTO priceRuleDTO) {
        PriceRuleDTO priceRule = priceRuleService.createPriceRule(priceRuleDTO);
        return new ResponseEntity<>(priceRule, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/deletetPriceRule/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity deletePriceRuleById(@PathVariable Long id) {
        priceRuleService.deletePriceRuleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/updateTypeRule/{id}", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<PriceRuleDTO> updatePriceRuleType(@PathVariable Long id, @RequestParam(name = "type", required = false) String newType){
        try{
            PriceRuleType priceRuleType = PriceRuleType.valueOf(newType);
            priceRuleService.updateType(id,priceRuleType);
            PriceRuleDTO priceRuleDTO = priceRuleService.getPriceRuleById(id);
            return new ResponseEntity<>(priceRuleDTO, HttpStatus.ACCEPTED);
        }catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = "/updatePriceRule/{id}", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<PriceRuleDTO> updatePriceRuleType(@PathVariable Long id, @RequestParam(name = "price") Float newPrice){
        try{
            priceRuleService.updatePrice(id,newPrice);
            PriceRuleDTO priceRuleDTO = priceRuleService.getPriceRuleById(id);
            return new ResponseEntity<>(priceRuleDTO, HttpStatus.ACCEPTED);
        }catch (Exception e) {
            throw e;
        }
    }
}
