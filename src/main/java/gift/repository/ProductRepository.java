package gift.repository;

import gift.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query("UPDATE Product p SET p.name = :#{#product.name}, " +
            "p.price = :#{#product.price}, p.imageUrl = :#{#product.imageUrl} WHERE p.id = :#{#product.id}")
    void update(Product product);

    void deleteById(Long id);

}
