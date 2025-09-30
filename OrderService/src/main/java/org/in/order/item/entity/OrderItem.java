package org.in.order.item.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="order_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	@Column(name="order_id")
	    private Long orderId;
	 	@Column(name="product_id")
	    private Long productId;
	    private Integer quantity;
	    private Double price;

}
