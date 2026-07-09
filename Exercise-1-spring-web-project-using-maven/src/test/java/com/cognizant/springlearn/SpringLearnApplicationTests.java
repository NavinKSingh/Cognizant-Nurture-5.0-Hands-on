package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;

/**
 * Hands on doc 2: "MockMVC - Test get country service" and
 * "MockMVC - Test get country service for exceptional scenario".
 *
 * NOTE: since Hands on doc 5 secures every endpoint with Spring Security +
 * JWT, these MockMvc calls now authenticate with httpBasic("user", "pwd")
 * (the in-memory USER account from SecurityConfig) so the requests reach
 * the controller instead of getting a 401.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
    void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(
                get("/countries/in").with(SecurityMockMvcRequestPostProcessors.httpBasic("user", "pwd")));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").exists());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").exists());
        actions.andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void testGetAllCountries() throws Exception {
        ResultActions actions = mvc.perform(
                get("/countries").with(SecurityMockMvcRequestPostProcessors.httpBasic("user", "pwd")));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$").isArray());
    }

    @Test
    void testGetCountryException() throws Exception {
        ResultActions actions = mvc.perform(
                get("/countries/zz").with(SecurityMockMvcRequestPostProcessors.httpBasic("user", "pwd")));
        actions.andExpect(status().isNotFound());
    }

    @Test
    void testUnauthorizedWithoutCredentials() throws Exception {
        ResultActions actions = mvc.perform(get("/countries"));
        actions.andExpect(status().isUnauthorized());
    }
}
