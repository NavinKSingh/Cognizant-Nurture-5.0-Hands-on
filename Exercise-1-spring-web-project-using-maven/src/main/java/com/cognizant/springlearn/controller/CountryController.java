package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import jakarta.validation.Valid;

/**
 * Follows the RESTful naming guidelines from Hands on doc 4:
 * base URL is the plural resource name "/countries", defined once at class
 * level via @RequestMapping.
 */
@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    public CountryController() {
        LOGGER.debug("CountryController constructed");
    }

    /** GET /countries -> all countries (doc 2 "REST - Get all countries") */
    @GetMapping
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("Start");
        ArrayList<Country> countries = countryService.getAllCountries();
        LOGGER.info("End");
        return countries;
    }

    /**
     * GET /countries/{code} -> specific country, case-insensitive
     * (doc 2 "REST - Get country based on country code" + exceptional scenario)
     */
    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.getCountry(code);
        LOGGER.info("End");
        return country;
    }

    /**
     * NOTE: doc 2 originally specified a singular "GET /country" endpoint
     * returning a hardcoded India response. Doc 4 explicitly asks us to
     * refactor CountryController to the plural "/countries" REST naming
     * convention, so that legacy endpoint is superseded by
     * getAllCountries()/getCountry() below. countryService.getCountryIndia()
     * is still available if you want to wire up the original doc 2 contract
     * separately.
     */

    /**
     * POST /countries -> create country with @Valid validation
     * (doc 4 "Create RESTful Web Service to handle POST request of Country"
     * + "Validating country code" + "Include global exception handler").
     * NOTE: validation errors are now handled centrally by
     * GlobalExceptionHandler rather than manual javax.validation code,
     * per the final step of doc 4.
     */
    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start");
        LOGGER.debug("Received country: {}", country);
        Country saved = countryService.addCountry(country);
        LOGGER.info("End");
        return saved;
    }
}
