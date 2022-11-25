package com.currency.service.impl;

import com.currency.enums.Symbol;
import com.currency.model.Currency;
import com.currency.repository.CurrencyRepo;
import com.currency.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyRepo currencyRepo;

    public CurrencyServiceImpl(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @Override
    public Currency addCurrency(Currency currency) {
        return currencyRepo.save(currency);
    }

    @Override
    public List<Currency> getAllCurrency() {
        return currencyRepo.findAll();
    }

    @Override
    public Currency getConversionRate(Symbol symbol) {
        return currencyRepo.findCurrencyBySymbol(symbol);
    }

    @Override
    public Currency updateCurrencyRate(Currency currency) {
        return currencyRepo.save(currency);
    }

    @Override
    public Double convertCurrency(Symbol from, double value, Symbol to) {
        Currency currency = getConversionRate(from);
        double rate = 0.0;
        rate = currency.getConversionRate().get(to);
        double convertedRate = rate * value;
        return convertedRate;
    }

    @Override
    public Double convertToCommonCurrency(Symbol symbol, double value) {
        Currency currency = getConversionRate(symbol);
        double rate = 0.0;
        rate = currency.getConversionRate().get(Symbol.USD);
        double convertedRate = rate * value;
        return convertedRate;
    }

    @Override
    public Double addCurrency(Symbol from, double valueFrom, Symbol to, double valueTo) {

        double addedRate = 0.0;
        if (from.equals(to)){
            addedRate = valueFrom + valueTo;
        }
        return addedRate;
    }

    @Override
    public Double subtractCurrency(Symbol from,double valueFrom, Symbol to, double valueTo){
        double newRate = 0.0;
        if (from.equals(to)){
            newRate = valueFrom - valueTo;
        }
        return newRate;
    }
}
