package ingeniance.supermarche.ingenianceDemo.serviceTest;

import ingeniance.supermarche.ingenianceDemo.Dto.CartDTO;
import ingeniance.supermarche.ingenianceDemo.entity.Cart;
import ingeniance.supermarche.ingenianceDemo.entity.Product;
import ingeniance.supermarche.ingenianceDemo.repository.CartRepository;
import ingeniance.supermarche.ingenianceDemo.repository.ProductRepository;
import ingeniance.supermarche.ingenianceDemo.service.impl.CartServiceImp;
import ingeniance.supermarche.ingenianceDemo.utils.ItemInCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @InjectMocks
    private CartServiceImp cartService;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ProductRepository productRepository;

    private Cart cart;
    private Product product;

    private List<ItemInCart> items;

    private ItemInCart item;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        cart.setIdCart(1L);

        product = new Product();
        product.setIdProduct(1L);
        product.setName("Test Product");

        item = new ItemInCart();
        item.setProductId(1L);
        item.setQuantity(1);

        items = new ArrayList<>();
        items.add(item);
    }

    @Test
    public void testCreateCart() {
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        cartService.createCart();

        verify(cartRepository, times(1)).save(any(Cart.class));
    }

    @Test
    public void testGetCartById() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));

        cartService.getCartById(1L);

        verify(cartRepository, times(1)).findById(1L);
    }

    @Test
    public void testAddItemToCart() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        cartService.addItemsToCart(1L, items);

        verify(cartRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).findById(1L);
        verify(cartRepository, times(1)).save(any(Cart.class));
    }

    @Test
    public void testRemoveItemFromCart() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        cartService.removeItemFromCart(1L, 1L);

        verify(cartRepository, times(1)).findById(1L);
        verify(cartRepository, times(1)).save(any(Cart.class));
    }

    @Test
    public void testDeleteCart() {
        cartService.deleteCart(1L);

        verify(cartRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetCartPrice() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));

        double totalPrice = cartService.getCartPrice(1L);

        verify(cartRepository, times(1)).findById(1L);
    }
}

