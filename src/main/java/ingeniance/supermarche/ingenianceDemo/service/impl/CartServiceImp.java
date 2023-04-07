package ingeniance.supermarche.ingenianceDemo.service.impl;

import ingeniance.supermarche.ingenianceDemo.Dto.CartDTO;
import ingeniance.supermarche.ingenianceDemo.Dto.CartItemDTO;
import ingeniance.supermarche.ingenianceDemo.entity.Cart;
import ingeniance.supermarche.ingenianceDemo.entity.CartItem;
import ingeniance.supermarche.ingenianceDemo.entity.Product;
import ingeniance.supermarche.ingenianceDemo.mapper.SupermarketMapper;
import ingeniance.supermarche.ingenianceDemo.repository.CartRepository;
import ingeniance.supermarche.ingenianceDemo.repository.ProductRepository;
import ingeniance.supermarche.ingenianceDemo.service.CartService;
import ingeniance.supermarche.ingenianceDemo.utils.ItemInCart;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    SupermarketMapper supermarketMapper = Mappers.getMapper(SupermarketMapper.class);

    private CartItemDTO convertToDTO(CartItem cartItem) {
        CartItemDTO CartItemDto = new CartItemDTO();
        CartItemDto.setIdCartItem(cartItem.getIdCartItem());
        CartItemDto.setProductId(cartItem.getProduct().getIdProduct());
        CartItemDto.setProductName(cartItem.getProduct().getName());
        CartItemDto.setQuantity(cartItem.getQuantity());
        return CartItemDto;
    }

    private CartDTO convertToDTO(Cart cart) {
        CartDTO cartDto = new CartDTO();
        cartDto.setIdCart(cart.getIdCart());
        cartDto.setCartItems(cart.getCartItems().stream().map(this::convertToDTO).collect(Collectors.toList()));
        return cartDto;
    }

    public CartDTO createCart() {
        return supermarketMapper.cartToCartDto(cartRepository.save(new Cart()));
    }

    public CartDTO getCartById(Long id) {
        return convertToDTO(cartRepository.findById(id).orElse(null));
    }

    public CartDTO addItemsToCart(Long cartId, List<ItemInCart> items) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            for (ItemInCart itemRequest : items) {
                Optional<Product> productOpt = productRepository.findById(itemRequest.getProductId());
                if (productOpt.isPresent()) {
                    Product product = productOpt.get();
                    CartItem cartItem = new CartItem();
                    cartItem.setProduct(product);
                    cartItem.setCart(cart);
                    cartItem.setQuantity(itemRequest.getQuantity());
                    cart.getCartItems().add(cartItem);
                }
            }
            return convertToDTO(cartRepository.save(cart));
        }
        return null;
    }

    public CartDTO removeItemFromCart(Long cartId, Long cartItemId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cart.getCartItems().removeIf(cartItem -> cartItem.getIdCartItem().equals(cartItemId));
            return convertToDTO(cartRepository.save(cart));
        }
        return null;
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public float getCartPrice(Long cartId) {
        Cart cart = null;
        try {
            cart = cartRepository.findById(cartId).get();
        } catch (Exception e) {
            new Exception("Cart not found with ID: " + cartId);
        }
        return cart.calculateTotalPrice();
    }
}
