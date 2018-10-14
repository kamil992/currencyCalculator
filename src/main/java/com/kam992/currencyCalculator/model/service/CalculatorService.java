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

    public double calculateCurrency(double value, String fromCurrency, String toCurrency) {
        double result = 0;
        //to change currency from USD
        double from = 1 / currencyDao.getCurrency(fromCurrency);
        double to = 1 / currencyDao.getCurrency(toCurrency);
        result = value * (from / to);

        return result;
    }
}
