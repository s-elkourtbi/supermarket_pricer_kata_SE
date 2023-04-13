package ingeniance.supermarche.ingenianceDemo.Dto;

import ingeniance.supermarche.ingenianceDemo.enumeration.PriceRuleType;

public class PriceRuleDTO {

    private Long idPriceRule;

    private String description;

    private PriceRuleType type;

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

    @Override
    public String toString() {
        return "PriceRuleDTO{" +
                "idPriceRule=" + idPriceRule +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", simplePrice=" + simplePrice +
                '}';
    }
}
