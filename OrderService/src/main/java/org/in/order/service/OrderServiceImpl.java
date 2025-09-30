package org.in.order.service;

import java.util.List;

import org.in.order.dto.OrderDto;
import org.in.order.entity.OrderEntity;
import org.in.order.item.dto.OrderItemDto;
import org.in.order.item.mapper.OrderItemMapper;
import org.in.order.item.repository.OrderItemRepository;
import org.in.order.mapper.OrderMapper;
import org.in.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderItemRepository itemRepo;
	@Override
	@Transactional
	public OrderDto createOrder(OrderDto dto, List<OrderItemDto> items) {
		OrderDto savedOrder=OrderMapper.convertToDto(orderRepo.save(OrderMapper.convertToEntity(dto)));
		
		 for (OrderItemDto item : items) {
	            item.setOrderId(savedOrder.getId());
	            itemRepo.save(OrderItemMapper.convertToEntity(item));
	        }
		return savedOrder;
	}
	
	@Override
	public List<OrderDto> getOrdersByUser(Long UserId) {
		List<OrderEntity> data=orderRepo.findByUserId(UserId);
		return OrderMapper.convertToDto(data);
	}
	@Override
	public List<OrderItemDto> getOrderItems(Long OrderId) {
		return OrderItemMapper.convertToDto(itemRepo.findByOrderId(OrderId));
	}
	
	
	

}
