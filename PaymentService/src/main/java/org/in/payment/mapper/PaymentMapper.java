package org.in.payment.mapper;

import org.in.payment.dto.PaymentDto;
import org.in.payment.entity.PaymentEntity;
import org.springframework.beans.BeanUtils;

public class PaymentMapper {
	
	public static PaymentEntity convertToEntity(PaymentDto dto) {
		PaymentEntity entity=new PaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	public static PaymentDto convertToDto(PaymentEntity entity) {
		PaymentDto dto=new PaymentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
