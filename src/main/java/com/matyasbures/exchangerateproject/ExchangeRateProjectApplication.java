package com.matyasbures.exchangerateproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is a Java Back-End Springboot application for a REST API that returns exchange rates.
 * The REST API recognizes one parameter, which is sent to it as a query attribute
 * named "usedb", with possible values of "true" or "false". If "true" is passed, the
 * API will return data from a database. If "false" is passed, the application will
 * fetch the current list of exchange rates from Česká spořitelna using an HTTP GET request.
 * The API endpoint is: https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates
 * with a query parameter of "web-api-key=c52a0682-4806-4903-828f-6cc66508329e".
 * The fetched data will be stored in an H2 database.
 */
@SpringBootApplication
public class ExchangeRateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateProjectApplication.class, args);
    }
}
