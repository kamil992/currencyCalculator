package com.kam992.currencyCalculator.demo;

import com.kam992.currencyCalculator.model.service.CurrencyService;

public class Main {
    public static void main(String[] args) {
        CurrencyService currencyService = CurrencyService.getInstance();

        double from = 0;
        double to = 0;

        from = currencyService.getCurrency("UAH");
        to = currencyService.getCurrency("PLN");

        double result = (1/to)/(1/from);

        System.out.println("1 pln = " + result + " of uah");
    }
}
