package com.scotiabank.colpatria.test.dev.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.scotiabank.colpatria.test.dev.erros.CityInvalidException;
import com.scotiabank.colpatria.test.dev.erros.Error;
import com.scotiabank.colpatria.test.dev.erros.ErrorApp;


@RestControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(CityInvalidException.class)
    public ResponseEntity<ErrorApp> HandleException(Exception e){
		ErrorApp model = new ErrorApp(Error.INVALID_CITY.getCode(), Error.INVALID_CITY.getMessage(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);
    }
}
