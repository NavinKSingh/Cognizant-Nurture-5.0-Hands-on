package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Country;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("main() started");
        SpringApplication.run(SpringLearnApplication.class, args);

        SpringLearnApplication app = new SpringLearnApplication();
        app.displayDate();
        app.displayCountry();
        app.displayCountries();

        LOGGER.info("main() finished");
    }

    /** Hands on 2: load SimpleDateFormat bean from date-format.xml and parse a date. */
    public void displayDate() {
        LOGGER.info("START");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            LOGGER.debug("{}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date", e);
        }
        LOGGER.info("END");
    }

    /**
     * Hands on 4/5: load the single "country" bean from country.xml twice
     * from the SAME context to demonstrate singleton scope (constructor
     * log only fires once). Switch country.xml to scope="prototype" to
     * observe the constructor firing twice instead.
     */
    public void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.debug("Same instance? {}", country == anotherCountry);
        LOGGER.info("END");
    }

    /** Hands on 6: load the full country list bean from country.xml. */
    @SuppressWarnings("unchecked")
    public void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countries = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
        for (Country c : countries) {
            LOGGER.debug("{}", c.toString());
        }
        LOGGER.info("END");
    }
}
