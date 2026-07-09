package com.cognizant.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanServiceApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoanServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - Loan Service");
        SpringApplication.run(LoanServiceApplication.class, args);
        LOGGER.info("END - Loan Service Started");
    }
}
