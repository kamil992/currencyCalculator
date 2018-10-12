package com.kam992.currencyCalculator.model.service;

import com.kam992.currencyCalculator.model.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private CurrencyDao currencyDao;

    public CalculatorService(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }
}
