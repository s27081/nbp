package com.example.demo;

import java.util.List;


public class Waluta {

    private String currency;
    private List<Rate> rates;

    public Waluta() {

    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}