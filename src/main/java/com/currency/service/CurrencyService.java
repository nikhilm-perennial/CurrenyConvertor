package com.currency.service;

import com.currency.enums.Symbol;
import com.currency.model.Currency;

import java.util.List;

public interface CurrencyService {

    Currency addCurrency(Currency currency);

    List<Currency> getAllCurrency() ;

    Currency getConversionRate(Symbol symbol);

    Currency updateCurrencyRate(Currency currency);

}
