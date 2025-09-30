package org.in.cart.entity;

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
@Table(name="cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		@Column(name="user_id")
	    private Long userId;
		@Column(name="product_id")
	    private Long productId;
	    private Integer quantity;

}
