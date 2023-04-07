package ingeniance.supermarche.ingenianceDemo.service;

import ingeniance.supermarche.ingenianceDemo.Dto.CartDTO;
import ingeniance.supermarche.ingenianceDemo.entity.Cart;
import ingeniance.supermarche.ingenianceDemo.utils.ItemInCart;

import java.util.List;

public interface CartService {

    public CartDTO createCart();

    public CartDTO getCartById(Long id);

    public CartDTO addItemsToCart(Long cartId, List<ItemInCart> items);

    public CartDTO removeItemFromCart(Long cartId, Long cartItemId);

    public void deleteCart(Long id);

    public float getCartPrice(Long cartId);

}
