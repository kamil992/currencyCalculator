package com.kam992.currencyCalculator.demo;

import com.kam992.currencyCalculator.model.dao.CurrencyDao;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        CurrencyDao currencyService = CurrencyDao.getInstance();

        double from = 0;
        double to = 0;

        from =  10 * currencyService.getCurrency("UAH");
        to = 10 * currencyService.getCurrency("PLN");



        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);

        String strFrom = decimalFormat.format(from).replace(',','.').toString();
        String strTo = decimalFormat.format(to).replace(',','.').toString();
        System.out.println(from);
        System.out.println(strFrom);

        System.out.println();
        System.out.println(to);
        System.out.println(strTo);

        double dFrom = Double.parseDouble(strFrom);
        double dTo =  Double.parseDouble(strTo);
        System.out.println();
        System.out.println(dFrom);
        System.out.println(dTo);

        double result = ((1.0/dTo) * 10)/(1.0/dFrom);
        String strResult = decimalFormat.format(result).replace(',','.').toString();

        double dResult = Double.parseDouble(strResult);

        System.out.println("1 pln = " +  dResult +" of uah");
    }
}
