package org.in.order.service;

import java.util.List;

import org.in.order.dto.OrderDto;
import org.in.order.item.dto.OrderItemDto;

public interface OrderService {
	
	public OrderDto createOrder(OrderDto dto,List<OrderItemDto> items);
	public List<OrderDto> getOrdersByUser(Long UserId);
	public List<OrderItemDto> getOrderItems(Long OrderId);

}
