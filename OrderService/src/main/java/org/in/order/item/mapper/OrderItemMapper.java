package org.in.order.item.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.in.order.item.dto.OrderItemDto;
import org.in.order.item.entity.OrderItem;
import org.springframework.beans.BeanUtils;

public class OrderItemMapper {
	
	public static OrderItem convertToEntity(OrderItemDto dto) {
		OrderItem entity=new OrderItem();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static OrderItemDto convertToDto(OrderItem entity) {
		OrderItemDto dto=new OrderItemDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	public static List<OrderItemDto> convertToDto(List<OrderItem> entities){
		return entities.stream()
				.map(OrderItemMapper::convertToDto)
				.collect(Collectors.toList());
	}

}
