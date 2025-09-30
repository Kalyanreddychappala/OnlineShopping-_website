package org.in.cart.mapper;

import org.in.cart.dto.CartItemDto;
import org.in.cart.entity.CartItem;
import org.springframework.beans.BeanUtils;

public class CartMapper {
	
	public static CartItem convertToEntity(CartItemDto dto) {
		CartItem entity=new CartItem();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static CartItemDto convertToDto(CartItem entity) {
		CartItemDto dto=new CartItemDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
