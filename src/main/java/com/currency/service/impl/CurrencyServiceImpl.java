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
}
