package org.in.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	
	private Long id;
	private Long orderId;
	private String paymentMethod;
	private Double amount;
	private String status;
}
