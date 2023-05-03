package ingeniance.supermarche.ingenianceDemo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Cart Entity
 */
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_CART", sequenceName = "SEQ_CART", allocationSize = 1, initialValue = 10)
@Table(name = "CART")
@Entity(name = "CART")
@DynamicUpdate
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_CART")
    @Column(name = "ID_CART")
    private Long idCart;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public float calculateTotalPrice() {
        return (float) cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}
