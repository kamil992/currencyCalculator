package com.kam992.currencyCalculator.controller;

import com.kam992.currencyCalculator.model.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String getCalculator(){
        return "index";
    }

    @PostMapping
    public String postCalculator(@RequestParam("value") double value,
                                 @RequestParam("from") String fromCurrency,
                                 @RequestParam("to") String toCurrency,
                                 Model model){

        double result = calculatorService.calculateCurrency(value, fromCurrency, toCurrency);

        model.addAttribute("result", result);

        return "index";
    }
}
