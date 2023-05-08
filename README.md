# Exchange Rate Application

## Description
This project is a Java Back-End Springboot application for a REST API that returns exchange rates.  
The REST API recognizes one parameter, which is sent to it as a query attribute named "usedb",  
with possible values of "true" or "false". If "true" is passed, the API will return data from a database.  
If "false" is passed, the application will fetch the current list of exchange rates from Česká spořitelna using an HTTP GET request.  
The API endpoint is: https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates with a query parameter of "web-api-key=c52a0682-4806-4903-828f-6cc66508329e".  
The fetched data will be stored in an H2 database.  

## REST API
The @RestController annotation indicates that this class serves as a RESTful web service.  
It contains a single method, getExchangeRates(), which handles GET requests to the "/api/exchangerates" endpoint.  
The @CrossOrigin annotation enables Cross-Origin Resource Sharing (CORS) for the "/api" endpoint,  
allowing the client application running on http://localhost:3000 to access this resource.
The @RequestMapping annotation specifies the base URL for all methods in this controller. Here, it is "/api".  

## Service
The ExchangeRateService class provides methods for retrieving and updating exchange rates.  
This service uses an external API to update the exchange rates,  
and stores them in a database for later retrieval. This class is annotated with the @Service annotation,  
which allows it to be automatically detected and registered as a bean in the Spring application context.  
This makes it easy to inject this service into other parts of the application that need to use its functionality.  

## Getting Started
To build the project, run:  
mvn clean install  

## Author
## Matyáš Bureš
