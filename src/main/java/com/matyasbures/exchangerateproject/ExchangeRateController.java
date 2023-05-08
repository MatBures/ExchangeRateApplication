package com.matyasbures.exchangerateproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    // Constructor injection to set the ExchangeRateService
    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    // Handles GET requests to the "/api/exchangerates" endpoint with optional "usedb" query parameter
    @GetMapping("/exchangerates")
    public ResponseEntity<?> getExchangeRates(@RequestParam(value = "usedb", required = false, defaultValue = "false") boolean useDb) throws IOException, InterruptedException {

        // If "usedb" query parameter is true, fetch exchange rates from database and return as response
        if (useDb) {
            List<ExchangeRateModel> exchangeRates = exchangeRateService.getExchangeRatesFromDatabase();
            return ResponseEntity.ok(exchangeRates);
        }

        // Otherwise, fetch exchange rates from API, update database, and return success message as response
        else {
            exchangeRateService.updateExchangeRatesFromAPI();
            return ResponseEntity.ok("Exchange rates from Česká spořitelna successfully updated to database");
        }
    }
}