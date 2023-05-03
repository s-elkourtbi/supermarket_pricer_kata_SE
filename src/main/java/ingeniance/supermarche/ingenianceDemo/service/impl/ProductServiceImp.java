package ingeniance.supermarche.ingenianceDemo.service.impl;

import ingeniance.supermarche.ingenianceDemo.entity.Product;
import ingeniance.supermarche.ingenianceDemo.repository.ProductRepository;
import ingeniance.supermarche.ingenianceDemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Contains business logic for Product operations.
 */
@Service
public class ProductServiceImp implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);

    @Autowired
    ProductRepository productRepository;
    @Override
    public Optional<Product> persist(Product product) {
        productRepository.save(product);
        return Optional.of(product);
    }

    @Override
    public Optional<List<Product>> findAll() {
        List<Product> products = new ArrayList<Product>();
        try {
            products = productRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Optional.of(products);
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = new Product();
        try {
            if(id != null) {
                product = productRepository.findById(id).get();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Optional.of(product);
    }

    @Override
    public void deleteById(Long id) {
        try {
          productRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
