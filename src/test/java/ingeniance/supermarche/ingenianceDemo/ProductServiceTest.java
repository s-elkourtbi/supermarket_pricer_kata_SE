package ingeniance.supermarche.ingenianceDemo;

import ingeniance.supermarche.ingenianceDemo.entity.Product;
import ingeniance.supermarche.ingenianceDemo.repository.ProductRepository;
import ingeniance.supermarche.ingenianceDemo.service.impl.ProductServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    ProductServiceImp productService;

    Product product1 = new Product();;
    Product product2= new Product();;

    @BeforeEach()
    public void setup() {
        MockitoAnnotations.openMocks(this);

        product1.setIdProduct(1L);
        product1.setName("FOUR");
        product1.setPrice(100F);

        product2.setIdProduct(2L);
        product2.setName("TV");
        product2.setPrice(200F);


    }

    @Test
    public void testSave_OK() {
        when(productRepository.save(any()))
                .thenReturn(product1);
        assertEquals(productService.persist(product1).get(), product1);
    }

    @Test
    public void testSave_NOK() {
        when(productRepository.save(any()))
                .thenReturn(product1);
        assertNotEquals(productService.persist(product1).get(), product2);
    }
}
