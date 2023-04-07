package ingeniance.supermarche.ingenianceDemo.mapper;

import ingeniance.supermarche.ingenianceDemo.Dto.CartDTO;
import ingeniance.supermarche.ingenianceDemo.Dto.CartItemDTO;
import ingeniance.supermarche.ingenianceDemo.Dto.ProductDto;
import ingeniance.supermarche.ingenianceDemo.entity.Cart;
import ingeniance.supermarche.ingenianceDemo.entity.CartItem;
import ingeniance.supermarche.ingenianceDemo.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SupermarketMapper {

    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);

    Cart cartDtoToCart(CartDTO cartDTO);
    CartDTO cartToCartDto(Cart cart);

    CartItem cartItemDtoToCartItem(CartItemDTO cartItemDTO);
    CartItemDTO cartItemToCartItem(CartItem cartItem);


}
