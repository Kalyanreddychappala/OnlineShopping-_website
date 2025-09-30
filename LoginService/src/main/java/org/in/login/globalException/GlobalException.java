package org.in.login.globalException;

import java.util.HashMap;
import java.util.Map;

import org.in.login.exception.DataNotExisted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(exception= {DataNotExisted.class})
	public ResponseEntity<Object> handleException(Exception e){
		Map<String,String> error=new HashMap<>();
		error.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
