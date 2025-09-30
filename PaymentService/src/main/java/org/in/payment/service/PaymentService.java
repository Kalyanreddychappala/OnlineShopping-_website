package org.in.payment.service;

import org.in.payment.dto.PaymentDto;

public interface PaymentService {
	
	public PaymentDto processPayment(PaymentDto dto);
	public PaymentDto getPaymentById(Long id);
	public PaymentDto updatePayment(Long id,PaymentDto dto);

}
