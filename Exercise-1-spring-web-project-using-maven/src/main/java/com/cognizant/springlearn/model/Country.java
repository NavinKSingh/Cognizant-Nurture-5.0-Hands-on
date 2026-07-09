package com.cognizant.springlearn.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hands on 4/5/6 (1__spring-rest-handson.docx) and Hands on 4 validation
 * (4__spring-rest-handson.docx).
 */
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @NotNull
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    @NotNull
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("getCode() invoked, code={}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("setCode() invoked, code={}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("getName() invoked, name={}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("setName() invoked, name={}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
