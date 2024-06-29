package com.example.demo;

public class CurrencyNotFoundException extends RuntimeException{
    public CurrencyNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
