package org.in.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.in.product.dto.ProductDto;
import org.in.product.entity.ProductEntity;
import org.in.product.mapper.ProductMapper;
import org.in.product.repoistory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;

	@Override
	public ProductDto add(ProductDto dto) {
		// TODO Auto-generated method stub
		return ProductMapper.convertToDto(repo.save(ProductMapper.convertToEntity(dto)));
	}

	@Override
	public ProductDto get(Long id) {
		// TODO Auto-generated method stub
		return ProductMapper.convertToDto(repo.findById(id).get());
	}

	@Override
	public List<ProductDto> getAll() {
		// TODO Auto-generated method stub
		List<ProductEntity> data=repo.findAll();
		return data.stream()
				.map(ProductMapper::convertToDto)
				.collect(Collectors.toList());
	}

}
