package org.in.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	
	private Long id;
    private Long userId;
    private Double totalAmount;
    private String status; 

}
