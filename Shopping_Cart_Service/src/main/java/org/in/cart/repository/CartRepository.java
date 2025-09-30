package org.in.cart.repository;

import java.util.List;
import java.util.Optional;

import org.in.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<CartItem, Integer> {
	List<CartItem> findByUserId(Long userId);
    Optional<CartItem> findByUserIdAndProductId(Long userId, Long productId);
	void deleteById(Long id);

}
