package org.in.cart.service;

import java.util.List;

import org.in.cart.dto.CartItemDto;

public interface CartService {
	
	public CartItemDto add(CartItemDto dto);
	public List<CartItemDto> getCartItems(Long UserId);
	public void removeItem(Long id);

}
