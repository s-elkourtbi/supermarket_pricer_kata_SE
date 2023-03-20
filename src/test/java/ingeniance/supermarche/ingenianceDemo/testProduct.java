package ingeniance.supermarche.ingenianceDemo;

import org.springframework.boot.test.context.SpringBootTest;


import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes= IngenianceDemoApplication.class)
public class testProduct {

    @MockBean
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Before
    public void setUp() {
        Product product = new Product();
        product.setName("Micro onde");
        product.setPrice(1OOL);
        product.setIdProduct(1L);

        Mockito.when(productService.newProduct(product))
                .thenReturn(Boolean.valueOf("1"));
    }

    @Test
    public void testNouveauClient() {
        Product product = new Product();
        product.setName("Micro onde");
        product.setPrice(1OOL);
        product.setIdProduct(1L);
        assertTrue(productService.newProduct(product));
    }
}
