package ingeniance.supermarche.ingenianceDemo;

import ingeniance.supermarche.ingenianceDemo.Dto.CartDTO;
import ingeniance.supermarche.ingenianceDemo.rest.CartRest;
import ingeniance.supermarche.ingenianceDemo.service.CartService;
import ingeniance.supermarche.ingenianceDemo.utils.ItemInCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartRestTest {

        @InjectMocks
        private CartRest cartController;

        @Mock
        private CartService cartService;

        private CartDTO cartDTO;

        private List<ItemInCart> items;

        private ItemInCart item;
     @BeforeEach
     public void setUp() {
          cartDTO = new CartDTO();
          cartDTO.setIdCart(1L);

         item = new ItemInCart();
         item.setProductId(1L);
         item.setQuantity(1);

         items = new ArrayList<>();
         items.add(item);
     }

    @Test
    public void testCreateCart() {
          when(cartService.createCart()).thenReturn(cartDTO);
          ResponseEntity<CartDTO> response = cartController.createCart();
          verify(cartService, times(1)).createCart();
    }
    @Test
    public void testGetCartById() {
        when(cartService.getCartById(1L)).thenReturn(cartDTO);

        ResponseEntity<CartDTO> response = cartController.getCartById(1L);

        verify(cartService, times(1)).getCartById(1L);
    }

    @Test
    public void testAddItemToCart() {
        cartController.addItemsToCart(1L, items);


        verify(cartService, times(1)).addItemsToCart(1L,items);
    }
    @Test
    public void testRemoveItemFromCart() {
        cartController.removeItemFromCart(1L, 1L);

        verify(cartService, times(1)).removeItemFromCart(1L, 1L);
    }

    @Test
    public void testDeleteCart() {
        cartController.deleteCart(1L);

        verify(cartService, times(1)).deleteCart(1L);
    }

    @Test
    public void testGetCartPrice() {
        when(cartService.getCartPrice(1L)).thenReturn(100.0f);

        ResponseEntity<Float> response = cartController.getCartPrice(1L);

        verify(cartService, times(1)).getCartPrice(1L);
    }
}
