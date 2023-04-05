package ingeniance.supermarche.ingenianceDemo.mapper;

import ingeniance.supermarche.ingenianceDemo.Dto.ProductDto;
import ingeniance.supermarche.ingenianceDemo.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SupermarketMapper {

    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);

}
