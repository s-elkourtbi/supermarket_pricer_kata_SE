package ingeniance.supermarche.ingenianceDemo.service;

import ingeniance.supermarche.ingenianceDemo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Optional<Product> persist(Product e);
    public Optional<List<Product>> findAll();
    public Optional<Product> findById(Long id);
    public void deleteById(Long id);
}
