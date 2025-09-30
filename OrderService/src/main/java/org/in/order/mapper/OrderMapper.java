package org.in.order.mapper;

import java.util.List;

import org.in.order.dto.OrderDto;
import org.in.order.entity.OrderEntity;
import org.springframework.beans.BeanUtils;

public class OrderMapper {
	
	public static OrderEntity convertToEntity(OrderDto dto) {
		OrderEntity entity=new OrderEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static OrderDto convertToDto(OrderEntity entity) {
		OrderDto dto=new OrderDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	 public static List<OrderDto> convertToDto(List<OrderEntity> entities) {
	        return entities.stream()
	                       .map(OrderMapper::convertToDto)
	                       .toList();
	    }

}
