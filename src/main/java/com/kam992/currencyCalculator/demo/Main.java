package com.kam992.currencyCalculator.demo;

import com.kam992.currencyCalculator.model.dao.CurrencyDao;

public class Main {
    public static void main(String[] args) {
        CurrencyDao currencyService = CurrencyDao.getInstance();

        double from = 0;
        double to = 0;

        from = currencyService.getCurrency("UAH");
        to = currencyService.getCurrency("PLN");

        double result = (1/to)/(1/from);

        System.out.println("1 pln = " + result + " of uah");
    }
}
