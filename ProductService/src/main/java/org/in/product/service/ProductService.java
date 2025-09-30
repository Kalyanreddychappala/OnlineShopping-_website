package org.in.product.service;

import java.util.List;

import org.in.product.dto.ProductDto;

public interface ProductService {
	
	public ProductDto add(ProductDto dto);
	public ProductDto get(Long id);
	public List<ProductDto> getAll();
}
