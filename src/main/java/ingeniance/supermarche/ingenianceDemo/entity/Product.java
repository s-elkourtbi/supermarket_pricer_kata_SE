package ingeniance.supermarche.ingenianceDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_PRODUCT", sequenceName = "SEQ_PRODUCT", allocationSize = 1, initialValue = 10)
@Table(name = "PRODUCT")
@Entity(name = "Product")
@DynamicUpdate
public class Product {

    /**
     * The product id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_PRODUCT")
    @Column(name = "ID_PRODUCT", nullable = false, unique = true)
    private Long idProduct;

    @Column(name = "NAME", length = 256, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "ID_PRICE_RULE")
    private PriceRule priceRule;

    @Column(name = "QUANTITY", nullable = true)
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
