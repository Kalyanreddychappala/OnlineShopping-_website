package org.in.product.repoistory;

import java.util.Optional;

import org.in.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	Optional<ProductEntity> findById(Long id);

}
