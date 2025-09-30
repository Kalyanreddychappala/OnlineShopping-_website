package org.in.login.mapper;

import org.in.login.dto.LoginDto;
import org.in.login.entity.LoginEntity;
import org.springframework.beans.BeanUtils;

public class LoginMapper {
	
	public static LoginEntity convertToEntity(LoginDto dto) {
		LoginEntity entity=new LoginEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static LoginDto convertTDto(LoginEntity entity) {
		LoginDto dto=new LoginDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
