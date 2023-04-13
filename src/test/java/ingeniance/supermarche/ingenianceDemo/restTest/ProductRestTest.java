package ingeniance.supermarche.ingenianceDemo.restTest;

import ingeniance.supermarche.ingenianceDemo.Dto.ProductDto;
import ingeniance.supermarche.ingenianceDemo.entity.Product;
import ingeniance.supermarche.ingenianceDemo.mapper.SupermarketMapper;
import ingeniance.supermarche.ingenianceDemo.rest.ProductRest;
import ingeniance.supermarche.ingenianceDemo.service.impl.ProductServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductRestTest {

    @Mock
    ProductServiceImp productService;

    SupermarketMapper supermarketMapper = Mappers.getMapper(SupermarketMapper.class);

    @InjectMocks
    ProductRest productRest;

    Product product = new Product();
    ProductDto productDto = new ProductDto();
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        product.setIdProduct(1L);
        product.setName("FOUR");

        productDto.setIdProduct(1L);
        productDto.setName("FOUR");


    }


    @Test
    public void testNewProduct() throws Exception {
        when(productService.persist(any())).thenReturn(Optional.of(product));

        assertEquals(productRest.newProduct(productDto),
                ResponseEntity.ok(productDto));
    }
}
