package ingeniance.supermarche.ingenianceDemo.rest;

import ingeniance.supermarche.ingenianceDemo.Dto.CartDTO;
import ingeniance.supermarche.ingenianceDemo.entity.Cart;
import ingeniance.supermarche.ingenianceDemo.mapper.SupermarketMapper;
import ingeniance.supermarche.ingenianceDemo.service.CartService;
import ingeniance.supermarche.ingenianceDemo.utils.ItemInCart;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartRest {

    @Autowired
    private CartService cartService;

    SupermarketMapper supermarketMapper = Mappers.getMapper(SupermarketMapper.class);



    @RequestMapping(value = "/newCart", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<CartDTO> createCart() {
        return new ResponseEntity<>(cartService.createCart(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getCartById/{cartId}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long cartId) {
        return new ResponseEntity<>(cartService.getCartById(cartId), HttpStatus.OK);
    }
    @RequestMapping(value = "/{cartId}/addItems", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<CartDTO> addItemsToCart(@PathVariable Long cartId, @RequestBody List<ItemInCart> items) {
        return new ResponseEntity<>(cartService.addItemsToCart(cartId, items), HttpStatus.OK);
    }

    @RequestMapping(value = "/{cartId}/items/{cartItemId}", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity<CartDTO> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long cartItemId) {
        return new ResponseEntity<>(cartService.removeItemFromCart(cartId, cartItemId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{cartId}/}", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{cartId}/price")
    public ResponseEntity<Float> getCartPrice(@PathVariable Long cartId) {
        float totalPrice = cartService.getCartPrice(cartId);
        return ResponseEntity.ok(totalPrice);
    }
}
