package org.in.login.service;

import java.util.ArrayList;

import org.in.login.dto.LoginDto;
import org.in.login.entity.LoginEntity;
import org.in.login.exception.DataNotExisted;
import org.in.login.mapper.LoginMapper;
import org.in.login.repositroy.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginEntity data=repo.findById(username).get();
		if(data==null) {
			throw new UsernameNotFoundException("User details are not existed: "+username);
		}
		return new User(data.getEmail(), data.getPassword(), new ArrayList<>());
	}

	@Override
	public LoginDto loadById(String email)throws DataNotExisted {
		if(repo.findById(email).isEmpty()) {
			throw new DataNotExisted("No mail id Existed on given: "+email);
		}
		return LoginMapper.convertTDto(repo.findById(email).get());
	}

}
