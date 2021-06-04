package com.kodlamaio.hrms.core.exceptionHandler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class Handler {

	@ExceptionHandler(MethodArgumentNotValidException.class)

	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception) {
		ValidationError validationError = new ValidationError(false, "Doğrulama Hatası",
				exception.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);

	}

}