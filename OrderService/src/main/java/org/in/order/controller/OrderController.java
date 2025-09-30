package org.in.order.controller;

import java.util.List;

import org.in.order.dto.OrderDto;
import org.in.order.item.dto.OrderItemDto;
import org.in.order.request.OrderRequest;
import org.in.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	@PostMapping("/create")
	public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequest request) {
	    OrderDto response = service.createOrder(request.getOrder(), request.getItems());
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	   // Get all orders by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getOrdersByUser(userId));
    }
    
    // Get items of an order
    @GetMapping("/items")
    public ResponseEntity<List<OrderItemDto>> getOrderItems(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.getOrderItems(orderId));
    }
}
