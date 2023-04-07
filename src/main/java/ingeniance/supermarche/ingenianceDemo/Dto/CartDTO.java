package ingeniance.supermarche.ingenianceDemo.Dto;

import java.util.List;

public class CartDTO {
    private Long idCart;
    private List<CartItemDTO> cartItems;

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }
}

