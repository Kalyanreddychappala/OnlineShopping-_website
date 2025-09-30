package org.in.order.repository;

import java.util.List;

import org.in.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	 List<OrderEntity> findByUserId(Long userId);
}


