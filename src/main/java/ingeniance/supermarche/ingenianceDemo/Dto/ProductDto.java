package ingeniance.supermarche.ingenianceDemo.Dto;

import ingeniance.supermarche.ingenianceDemo.entity.PriceRule;

public class ProductDto {

    private Long idProduct;

    private String name;

    private PriceRule priceRule;

    private Integer quantity;


    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriceRule getPriceRule() {
        return priceRule;
    }

    public void setPriceRule(PriceRule priceRule) {
        this.priceRule = priceRule;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
