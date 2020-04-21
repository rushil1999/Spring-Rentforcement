package com.rental.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleException(CustomException c){
		
		return new ResponseEntity<String>(c.getMessage(), HttpStatus.CONFLICT);
		
	}

}
