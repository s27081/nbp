package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/waluta")
public class walutaController {

    private final walutaService walutaService;

    public walutaController(walutaService walutaService) {
        this.walutaService = walutaService;
    }
    @GetMapping("/{currency}")
    public ResponseEntity<Waluta> getCurrency(@RequestParam(defaultValue = "1") Long days, @PathVariable("currency") String currencyId) throws CurrencyNotFoundException{
        Waluta waluta = walutaService.calculateCurrency(currencyId, days);
        return ResponseEntity.ok(waluta);

    }
}
