package ingeniance.supermarche.ingenianceDemo.entity;

import ingeniance.supermarche.ingenianceDemo.enumeration.PriceRuleType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Price rule Entity
 */
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_PRICE", sequenceName = "SEQ_PRICE", allocationSize = 1, initialValue = 10)
@Table(name = "PRICE_RULE")
@Entity(name = "PRICE_RULE")
@DynamicUpdate
public class PriceRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_PRICE")
    @Column(name = "ID_PRICE_RULE")
    private Long idPriceRule;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "price_rule_type", nullable = false)
    private PriceRuleType type;

    @Column(name = "simple_price", scale = 2)
    private Float simplePrice;


    public Long getIdPriceRule() {
        return idPriceRule;
    }

    public void setIdPriceRule(Long idPriceRule) {
        this.idPriceRule = idPriceRule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriceRuleType getType() {
        return type;
    }

    public void setType(PriceRuleType type) {
        this.type = type;
    }

    public Float getSimplePrice() {
        return simplePrice;
    }

    public void setSimplePrice(Float simplePrice) {
        this.simplePrice = simplePrice;
    }

}
