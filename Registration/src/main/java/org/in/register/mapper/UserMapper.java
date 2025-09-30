package org.in.register.mapper;

import org.in.register.dto.UserDto;
import org.in.register.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserMapper {
	
	public static UserEntity convertToEntity(UserDto dto) {
		
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static UserDto convertToDto(UserEntity entity) {
		UserDto dto=new UserDto(entity.getId(),entity.getName(),entity.getEmail(),entity.getPassword(),entity.getAddress());
		return dto;
	}

}
