package org.in.product.controller;

import java.util.List;

import org.in.product.dto.ProductDto;
import org.in.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping("/products")
	public ResponseEntity<ProductDto> add(@RequestBody ProductDto dto){
		ProductDto response=service.add(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> get(@PathVariable Long id,@RequestBody ProductDto dto){
		ProductDto response=service.get(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@GetMapping("/productGetAll")
	public ResponseEntity<List<ProductDto>> getAll(){
		List<ProductDto> response=service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
