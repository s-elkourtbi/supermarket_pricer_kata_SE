package ingeniance.supermarche.ingenianceDemo.repoTest;

import ingeniance.supermarche.ingenianceDemo.entity.Product;
import ingeniance.supermarche.ingenianceDemo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductRepoTest {

    @Mock
    ProductRepository productRepository;
    Product product = new Product();
    @BeforeEach
    public void setUp() {

        product.setIdProduct(1L);
        product.setName("FOUR");


    }

    @Test
    public void testInsert_OK(){

        productRepository.save(product);
        System.out.println(">>>>>>>>>>>>>> size: "+productRepository.findAll().size());
        List<Product> products = productRepository.findAll();
    }
}
