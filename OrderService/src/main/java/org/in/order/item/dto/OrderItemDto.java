package org.in.order.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
	
	private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;

}
