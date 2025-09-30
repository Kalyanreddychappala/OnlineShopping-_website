package org.in.register.service;

import org.in.register.dto.UserDto;
import org.in.register.exception.DataAlreadyExisted;

public interface UserService {

	public UserDto add(UserDto dto) throws DataAlreadyExisted;
}
