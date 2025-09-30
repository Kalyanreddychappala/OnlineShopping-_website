package org.in.cart.controller;

import java.util.List;

import org.in.cart.dto.CartItemDto;
import org.in.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CartController {
	@Autowired
	private CartService service;
	
	@PostMapping("/cartadd")
	public ResponseEntity<CartItemDto> add(@RequestBody CartItemDto dto){
		CartItemDto response=service.add(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@GetMapping("/cart/{userId}")
	public ResponseEntity<List<CartItemDto>> getCartItems(@PathVariable Long userId){
		List<CartItemDto> response=service.getCartItems(userId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@DeleteMapping("/deleted/{id}")
	public ResponseEntity<Object> removeItem(@PathVariable Long id){
		service.removeItem(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Items deleted successfully");
	}
	

}
