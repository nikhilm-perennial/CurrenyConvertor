package com.currency.repository;

import com.currency.enums.Symbol;
import com.currency.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {

    Currency findCurrencyBySymbol(Symbol symbol);
}
