package com.example.todoApI.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.todoApI.model.NullType;

@RestControllerAdvice
public class APIErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullPoint(RuntimeException runtimeException, WebRequest request) {
		NullType nullType = new NullType(204, runtimeException.getMessage());
		System.out.println(nullType);
		return handleExceptionInternal(runtimeException, nullType, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> client(RuntimeException runtimeException, WebRequest request) {
		return handleExceptionInternal(runtimeException, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgument(RuntimeException runtimeException, WebRequest request) {
		NullType nullType = new NullType(406, runtimeException.getMessage());
		System.out.println(nullType);
		return handleExceptionInternal(runtimeException, nullType, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE,
				request);
	}
}