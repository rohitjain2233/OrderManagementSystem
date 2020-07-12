package com.oms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(ProductNotFoundException e) {
		CustomErrorResponse error = new CustomErrorResponse("PRODUCT_NOT_FOUND_ERROR", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(OrderNotFoundException e) {
		CustomErrorResponse error = new CustomErrorResponse("ORDER_NOT_FOUND_ERROR", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
