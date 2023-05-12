package com.matyasbures.exchangerateproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * The @RestController annotation indicates that this class serves as a RESTful web service.
 * It contains a single method, getExchangeRates(), which handles GET requests to the "/api/exchangerates" endpoint.
 * The @CrossOrigin annotation enables Cross-Origin Resource Sharing (CORS) for the "/api" endpoint,
 * allowing the client application running on http://localhost:3000 to access this resource.
 * The @RequestMapping annotation specifies the base URL for all methods in this controller. Here, it is "/api".
 */
@RestController
@RequestMapping("/api")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    // Handles GET requests to the "/api/exchangerates" endpoint with optional "usedb" query parameter
    @GetMapping("/exchangerates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(value = "usedb", required = false, defaultValue = "false") boolean useDb) throws IOException, InterruptedException {

        // If "usedb" query parameter is true, fetch exchange rates from database and return as response
        if (useDb) {
            List<ExchangeRateModel> exchangeRates = exchangeRateService.getExchangeRatesFromDatabase();
            return ResponseEntity.ok(exchangeRates);
        }

        // Otherwise, fetch exchange rates from API and update database
        else {
            exchangeRateService.updateExchangeRatesFromAPI();
            return ResponseEntity.ok(exchangeRateService.updateExchangeRatesFromAPI());
        }
    }
}