package ingeniance.supermarche.ingenianceDemo.repository;

import ingeniance.supermarche.ingenianceDemo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}

