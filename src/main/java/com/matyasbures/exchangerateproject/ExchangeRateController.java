package com.matyasbures.exchangerateproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping ("/exchangerates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(value = "usedb", required = false, defaultValue = "false") boolean useDb) throws IOException, InterruptedException {
        if (useDb) {
            List<ExchangeRateModel> exchangeRates = exchangeRateService.getExchangeRatesFromDatabase();
            return ResponseEntity.ok(exchangeRates);
        } else {
            exchangeRateService.updateExchangeRatesFromAPI();
            return ResponseEntity.ok("Exchange rates from Česká spořitelna successfully updated to database");
        }
    }
}