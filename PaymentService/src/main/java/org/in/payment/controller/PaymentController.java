package org.in.payment.controller;

import org.in.payment.dto.PaymentDto;
import org.in.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping("/payments")
	public ResponseEntity<Object> processPayment(@RequestBody PaymentDto dto){
		PaymentDto response=service.processPayment(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/payment/{id}")
	public ResponseEntity<Object> getPaymentById(@PathVariable Long id){
		PaymentDto response=service.getPaymentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/paymentUpdate/{id}")
	public ResponseEntity<Object> updatePayment(@PathVariable Long id,@RequestBody PaymentDto dto){
		PaymentDto response=service.updatePayment(id, dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
}
