package gift.repository;

import gift.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void update(Product product);
    void delete(Long id);

}
