package ingeniance.supermarche.ingenianceDemo.repository;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;
import ingeniance.supermarche.ingenianceDemo.enumeration.PriceRuleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PriceRuleRepository extends JpaRepository<PriceRule, Long> {

    @Modifying
    @Query("update PRICE_RULE pr set pr.simplePrice = :simplePrice where pr.idPriceRule = :id")
    void updatePrice(@Param(value = "id") long id, @Param(value = "simplePrice") Float simplePrice);

    @Modifying
    @Query("update PRICE_RULE pr set pr.type = :type where pr.idPriceRule = :id")
    void updateType(@Param(value = "id") long id, @Param(value = "type") PriceRuleType type);
}
