package org.in.payment.service;

import org.in.payment.dto.PaymentDto;
import org.in.payment.entity.PaymentEntity;
import org.in.payment.mapper.PaymentMapper;
import org.in.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository repo;
	@Override
	public PaymentDto processPayment(PaymentDto dto) {
		// TODO Auto-generated method stub
		dto.setStatus("PENDING");
		return PaymentMapper.convertToDto(repo.save(PaymentMapper.convertToEntity(dto)));
	}

	@Override
	public PaymentDto getPaymentById(Long id) {
		// TODO Auto-generated method stub
		PaymentEntity data= repo.findById(id).orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
		return PaymentMapper.convertToDto(data);
	}

	@Override
	public PaymentDto updatePayment(Long id, PaymentDto dto) {
		PaymentDto existing=getPaymentById(id);
		 existing.setOrderId(dto.getOrderId());
	        existing.setPaymentMethod(dto.getPaymentMethod());
	        existing.setAmount(dto.getAmount());
	        existing.setStatus(dto.getStatus());
		return PaymentMapper.convertToDto(repo.save(PaymentMapper.convertToEntity(existing)));
	}

}
