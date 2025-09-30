package org.in.register.globalexception;

import java.util.HashMap;
import java.util.Map;

import org.in.register.exception.DataAlreadyExisted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(DataAlreadyExisted.class)
	public ResponseEntity<Object> handleException(Exception e){
		Map<String, String> error=new HashMap<>();
		error.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
}
