package gift;

import gift.model.Product;
import gift.model.User;
import gift.model.Wishlist;
import gift.repository.ProductRepository;
import gift.repository.UserRepository;
import gift.repository.WishlistRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class WishRepositoryTest {

    @Autowired
    private WishlistRepository wishRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager; // 영속성 컨텍스트 관리를 위해 주입

    @Test
    @DisplayName("위시리스트를 저장하고, 회원의 이메일과 상품의 이름으로 검증한다.")
    void saveWishAndFind() {
        // given: 테스트 데이터 준비
        User user = new User("test@example.com", "password123", "me");
        Product product = new Product("테스트 상품", 10000, false,"http://example.com/image.jpg");

        userRepository.save(user);
        productRepository.save(product);

        Wishlist wish = new Wishlist(user, product);

        // when: 위시리스트 저장
        Wishlist savedWish = wishRepository.save(wish);

        // 영속성 컨텍스트를 초기화하여 DB에서 직접 조회하도록 강제
        entityManager.flush();
        entityManager.clear();

        // then: 저장된 데이터 검증
        Wishlist foundWish = wishRepository.findById(savedWish.getId())
                .orElseThrow(() -> new AssertionError("저장된 Wish를 찾을 수 없습니다."));

        assertThat(foundWish).isNotNull();
        assertThat(foundWish.getUser().getEmail()).isEqualTo(user.getEmail());
        assertThat(foundWish.getProduct().getName()).isEqualTo(product.getName());
        assertThat(foundWish.getUser().getId()).isEqualTo(user.getId());
    }
}