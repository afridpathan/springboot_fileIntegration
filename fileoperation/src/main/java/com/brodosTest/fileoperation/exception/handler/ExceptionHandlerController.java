package com.brodosTest.fileoperation.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	public Map<String, String> handleException(Throwable e) {

		Map<String, String> errorMap = new HashMap<>();

		errorMap.put("errorMessage", "Something Went Wrong, Please contact administrator.");
		e.printStackTrace();

		return errorMap;
	}
}
