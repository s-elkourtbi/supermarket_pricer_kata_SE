package ingeniance.supermarche.ingenianceDemo.entity;

import ingeniance.supermarche.ingenianceDemo.factory.PriceCalculator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Cart Item Entity
 */
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_CART_ITEM", sequenceName = "SEQ_CART_ITEM", allocationSize = 1, initialValue = 10)
@Table(name = "CART_ITEM")
@Entity(name = "CART_ITEM")
@DynamicUpdate
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_CART_ITEM")
    @Column(name = "ID_CART_ITEM")
    private Long idCartItem;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "QUANTITY", nullable = true)
    private Integer quantity;

    public Long getIdCartItem() {
        return idCartItem;
    }

    public void setIdCartItem(Long idCartItem) {
        this.idCartItem = idCartItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

        public Float getTotalPrice() {
            return PriceCalculator.calculateFinalPrice(product.getPriceRule(), quantity);
        }
}

