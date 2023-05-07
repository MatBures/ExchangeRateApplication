package com.matyasbures.exchangerateproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/exchangerates")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public List<ExchangeRateModel> getExchangeRates(@RequestParam(value = "usedb", required = false, defaultValue = "false") boolean useDb) throws IOException, InterruptedException {
        if (useDb) {
            return exchangeRateService.getExchangeRatesFromDatabase();
        } else {
            return exchangeRateService.updateExchangeRatesFromAPI();
        }
    }
}