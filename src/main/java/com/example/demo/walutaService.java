package com.example.demo;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Service
public class walutaService {

    private final String url = "http://api.nbp.pl/api/exchangerates/rates/A/{currencyId}/{startDate}/{endDate}";

    private final RestTemplate restTemplate;

    private final WalutaJpaRepository walutaJpaRepository;


    public walutaService(RestTemplate restTemplate, WalutaJpaRepository walutaJpaRepository) {
        this.restTemplate = restTemplate;
        this.walutaJpaRepository = walutaJpaRepository;
    }

    public Waluta calculateCurrency(String currencyId, Long days){
        LocalDate localDate = LocalDate.now();
        LocalDate startDate = localDate.minusDays(days);
        Waluta cur = restTemplate.getForObject(url, Waluta.class, currencyId, startDate, localDate);
        Double sum = 0.0;
        for(Rate rate : cur.getRates()) {
        sum+= rate.getMid();
        }
        Double avgSum = sum/cur.getRates().size();
        Database db = new Database(cur.getCurrency(),days,avgSum,localDate);
        addRecord(db);
        return cur;
    }

    public void addRecord(Database database){
        walutaJpaRepository.save(database);
    }

}
