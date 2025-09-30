package org.in.cart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.in.cart.dto.CartItemDto;
import org.in.cart.entity.CartItem;
import org.in.cart.mapper.CartMapper;
import org.in.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository repo;

	@Override
	public CartItemDto add(CartItemDto dto) {
		CartItem entity=CartMapper.convertToEntity(dto);
		Optional<CartItem> existingItem=repo.findByUserIdAndProductId(entity.getUserId(),entity.getProductId());
		if(existingItem.isPresent()) {
			CartItem item=existingItem.get();
			item.setQuantity(item.getQuantity() + entity.getQuantity());
		}
		return CartMapper.convertToDto(repo.save(CartMapper.convertToEntity(dto)));
	}

	@Override
	public List<CartItemDto> getCartItems(Long UserId) {
		List<CartItem> data=repo.findByUserId(UserId);
		return data.stream()
				.map(CartMapper::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void removeItem(Long id) {
		repo.deleteById(id);

	}

}
