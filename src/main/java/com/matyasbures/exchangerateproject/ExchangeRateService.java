package com.matyasbures.exchangerateproject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import java.net.http.HttpResponse;

import java.util.Collections;
import java.util.List;

/**
 * The ExchangeRateService class provides methods for retrieving and updating exchange rates.
 * This service uses an external API to update the exchange rates, and stores them in a database for later retrieval.
 * This class is annotated with the @Service annotation, which allows it to be automatically detected and registered as a
 * bean in the Spring application context. This makes it easy to inject this service into other parts of the application
 * that need to use its functionality.
 */
@Service
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    // This constructor method takes an instance of ExchangeRateRepository as a parameter
    // and assigns it to the exchangeRateRepository field of the ExchangeRateService class
    @Autowired
    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    // Method to retrieve all Exchange Rate models from the database
    public List<ExchangeRateModel> getExchangeRatesFromDatabase() {
        return exchangeRateRepository.findAll();
    }

    // Method to update Exchange Rates by calling an external API
    // Throws IOException and InterruptedException if there is an issue with the API call
    public List<ExchangeRateModel> updateExchangeRatesFromAPI() throws IOException, InterruptedException {
        String url = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";

        // Create a new HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Build the HTTP request using the provided URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send the HTTP request and store the response in a variable
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Create a new instance of the ObjectMapper class to map JSON data to Java objects
        ObjectMapper objectMapper = new ObjectMapper();

        // Register the JavaTimeModule to enable date/time serialization and deserialization
        objectMapper.registerModule(new JavaTimeModule());

        // Configure the ObjectMapper to ignore unknown properties when deserializing JSON data
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Deserialize the JSON response into a list of ExchangeRateModel objects
        List<ExchangeRateModel> newExchangeRateModels = objectMapper.readValue(response.body(), new TypeReference<List<ExchangeRateModel>>() {});

        // Retrieve the old list of ExchangeRateModel objects from the database
        List<ExchangeRateModel> oldExchangeRateModels = exchangeRateRepository.findAll();

        // If the old and new lists are equal, return an empty list
        if (oldExchangeRateModels.equals(newExchangeRateModels)) {
            return Collections.emptyList();
        }

        // Otherwise, delete the old list from the database and save the new list
        else {
            exchangeRateRepository.deleteAll();
            exchangeRateRepository.saveAll(newExchangeRateModels);
            return newExchangeRateModels;
        }
    }
}