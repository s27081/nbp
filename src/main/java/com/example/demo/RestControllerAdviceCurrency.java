package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceCurrency {

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(CurrencyNotFoundException currencyNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chuj");
    }

}
