package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries = new ArrayList<>();
        countries.add(context.getBean("IN", Country.class));
        countries.add(context.getBean("US", Country.class));
        countries.add(context.getBean("AU", Country.class));
        countries.add(context.getBean("CN", Country.class));
        countries.add(context.getBean("GB", Country.class));

        LOGGER.debug("countries={}", countries);
        LOGGER.info("END");
        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        LOGGER.info("START");
        LOGGER.debug("code={}", code);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean(code.toUpperCase(), Country.class);

        LOGGER.debug("country={}", country);
        LOGGER.info("END");
        return country;
    }
}
