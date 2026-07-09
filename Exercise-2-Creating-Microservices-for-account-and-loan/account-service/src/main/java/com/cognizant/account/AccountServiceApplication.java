package com.cognizant.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AccountServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - Account Service");
        SpringApplication.run(AccountServiceApplication.class, args);
        LOGGER.info("END - Account Service Started");
    }
}
