package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    // GET /countries → returns all countries list
    @GetMapping("/countries")
    public java.util.List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        java.util.List<Country> countries = new java.util.ArrayList<>();
        countries.add(context.getBean("IN", Country.class));
        countries.add(context.getBean("US", Country.class));
        countries.add(context.getBean("AU", Country.class));
        countries.add(context.getBean("CN", Country.class));
        countries.add(context.getBean("GB", Country.class));

        LOGGER.debug("countries={}", countries);
        LOGGER.info("END - getAllCountries");

        return countries;
    }

    // GET /countries/{code} → returns country by code
    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        LOGGER.info("START - getCountryByCode");
        LOGGER.debug("code={}", code);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean(code.toUpperCase(), Country.class);

        LOGGER.debug("country={}", country);
        LOGGER.info("END - getCountryByCode");

        return country;
    }
}
