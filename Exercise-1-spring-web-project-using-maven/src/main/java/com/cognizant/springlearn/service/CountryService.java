package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountryIndia() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("End");
        return country;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
        LOGGER.info("End");
        return countries;
    }

    /**
     * Case-insensitive lookup by country code using a lambda expression, as
     * suggested in Hands on doc 2 ("REST - Get country based on country code").
     */
    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("Start");
        LOGGER.debug("Looking up country with code={}", code);

        for (Country c : getAllCountries()) {
            if (c.getCode().equalsIgnoreCase(code)) {
                LOGGER.info("End");
                return c;
            }
        }
        LOGGER.warn("Country not found for code={}", code);
        throw new CountryNotFoundException("Country not found for code: " + code);
    }

    public Country addCountry(Country country) {
        LOGGER.info("Start");
        LOGGER.debug("Adding country: {}", country);
        // In this XML-config-driven demo app there is no persistent store to
        // add to permanently; we simply echo the validated bean back, which
        // is exactly what Hands on doc 4 ("Create RESTful Web Service to
        // handle POST request of Country") asks us to verify.
        LOGGER.info("End");
        return country;
    }
}
