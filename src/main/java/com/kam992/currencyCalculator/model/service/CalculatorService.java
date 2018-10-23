package com.kam992.currencyCalculator.model.service;

import com.kam992.currencyCalculator.model.dao.CurrencyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CalculatorService {

    @Autowired
    private CurrencyDao currencyDao;

    public CalculatorService(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    public double calculateCurrency(double value, String fromCurrency, String toCurrency) {
        double result;
        //to change currency from USD
        double from = currencyDao.getCurrency(fromCurrency);
        double to = currencyDao.getCurrency(toCurrency);


        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);

        String strFrom = decimalFormat.format(from).replace(',','.').toString();
        String strTo = decimalFormat.format(to).replace(',','.').toString();
        double dFrom = Double.parseDouble(strFrom);
        double dTo =  Double.parseDouble(strTo);

        result = ((1/dFrom) * value) / (1/dTo);

        String strResult = decimalFormat.format(result).replace(',','.').toString();

        result = Double.parseDouble(strResult);

        return result;
    }
}
