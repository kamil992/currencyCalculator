package com.kam992.currencyCalculator.model.dao;

import com.kam992.currencyCalculator.model.Utils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


@Component
public class CurrencyDao {
    private static CurrencyDao ourInstance = new CurrencyDao();

    public static CurrencyDao getInstance() {
        return ourInstance;
    }

    private CurrencyDao() {
    }

    public double getCurrency(String countryAbbreviation){
        StringBuilder USDCountryAbbreviation = new StringBuilder("USD");
        USDCountryAbbreviation.append(countryAbbreviation);

        String websiteResponse = Utils.readWebsiteContent("http://www.apilayer.net/api/live?access_key=8ea914e523d830b51f4a57873a170e16&format=1");
        //object with info from website:
        JSONObject root = new JSONObject(websiteResponse);
        JSONObject currency = root.getJSONObject("quotes");


        double countryCurrency = currency.getDouble(USDCountryAbbreviation.toString());


        return countryCurrency;
    }

}
