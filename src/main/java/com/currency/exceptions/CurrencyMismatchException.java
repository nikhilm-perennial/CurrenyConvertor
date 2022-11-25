package com.currency.exceptions;

import com.currency.model.Currency;

public class CurrencyMismatchException extends Exception{

    public CurrencyMismatchException(String message) {
        super(message);
    }
}
