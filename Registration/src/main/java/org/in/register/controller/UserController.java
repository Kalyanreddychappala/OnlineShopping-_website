package org.in.register.controller;

import org.in.register.dto.UserDto;
import org.in.register.exception.DataAlreadyExisted;
import org.in.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto dto) throws DataAlreadyExisted{
		UserDto response=service.add(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
