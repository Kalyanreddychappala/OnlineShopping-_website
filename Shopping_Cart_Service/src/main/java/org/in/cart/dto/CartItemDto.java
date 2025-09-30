package org.in.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

		private Long id;
	    private Long userId;
	    private Long productId;
	    private Integer quantity;
}
