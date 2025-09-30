package org.in.register.service;

import org.in.register.dto.UserDto;
import org.in.register.entity.UserEntity;
import org.in.register.exception.DataAlreadyExisted;
import org.in.register.mapper.UserMapper;
import org.in.register.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public UserDto add(UserDto dto) throws DataAlreadyExisted {
		if(repo.findByEmail(dto.getEmail()).isPresent()) {
			throw new DataAlreadyExisted("Email id Already Existed: "+dto.getEmail());
		}
		UserEntity data=UserMapper.convertToEntity(dto);
		data.setPassword(encoder.encode(dto.getPassword()));
		return UserMapper.convertToDto(repo.save(data));
	}

}
