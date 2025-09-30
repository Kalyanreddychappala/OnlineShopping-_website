package org.in.product.mapper;

import org.in.product.dto.ProductDto;
import org.in.product.entity.ProductEntity;
import org.springframework.beans.BeanUtils;

public class ProductMapper {
	
	public static ProductEntity convertToEntity(ProductDto dto) {
		ProductEntity entity=new ProductEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static ProductDto convertToDto(ProductEntity entity) {
		ProductDto dto=new ProductDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
