package com.currency.controller;

import com.currency.enums.Symbol;
import com.currency.model.Currency;
import com.currency.service.impl.CurrencyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

    private CurrencyServiceImpl currencyService;

    public CurrencyController(CurrencyServiceImpl currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("/currency")
    public ResponseEntity<Currency> addCurrency(@RequestBody Currency currency){
        Currency result = currencyService.addCurrency(currency);
        if (result!=null)
            return ResponseEntity.ok(currency);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/currency")
    public ResponseEntity<List<Currency>> getAllCurrency(){
        List<Currency> currencies = currencyService.getAllCurrency();
        if (!currencies.isEmpty())
            return ResponseEntity.ok(currencies);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/currency/update")
    public ResponseEntity<Currency> updateCurrency(@RequestBody Currency currency){
        Currency result = currencyService.updateCurrencyRate(currency);
        if (result!=null)
            return ResponseEntity.ok(currency);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/currency/{symbol}")
    public ResponseEntity<Currency> getConversionRate(@PathVariable Symbol symbol){
        Currency currency = currencyService.getConversionRate(symbol);
        if (currency!=null)
            return ResponseEntity.ok(currency);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @GetMapping("/currency/{from}/{val}/{to}")
    public ResponseEntity<Double> convertCurrency(@PathVariable Symbol from,
                                                  @PathVariable double val,
                                                  @PathVariable Symbol to){
        double rate = currencyService.convertCurrency(from,val,to);
        return ResponseEntity.ok(rate);
    }
}
