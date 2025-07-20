package gift.repository;

import gift.model.Product;
import gift.model.Wishlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Page<Product> findByUserEmail(Pageable attr0, String userEmail);

    boolean existsByUserEmailAndProductId(String userEmail, Long productId);

    void deleteByUserEmailAndProductId(String email, Long productId);
}