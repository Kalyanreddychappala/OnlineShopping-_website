package org.in.order.request;

import java.util.List;

import org.in.order.dto.OrderDto;
import org.in.order.item.dto.OrderItemDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	 private OrderDto order;
	    private List<OrderItemDto> items;

}
