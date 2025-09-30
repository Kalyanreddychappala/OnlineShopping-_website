package org.in.login.service;

import org.in.login.dto.LoginDto;
import org.in.login.exception.DataNotExisted;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService {
	
	public LoginDto loadById(String email) throws DataNotExisted;

}
