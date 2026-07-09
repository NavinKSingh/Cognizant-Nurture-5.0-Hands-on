package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    // Secret key for signing JWT (must be at least 256 bits for HS256)
    private static final String SECRET_KEY = "secretkeysecretkeysecretkey12345678";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");
        LOGGER.debug("authHeader={}", authHeader);

        // Step 1: Get username from Authorization header
        String user = getUser(authHeader);
        LOGGER.debug("user={}", user);

        // Step 2: Generate JWT token
        String token = generateJwt(user);
        LOGGER.debug("token={}", token);

        // Step 3: Return token in response map
        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END");
        return map;
    }

    // Decode Base64 Authorization header to get username
    private String getUser(String authHeader) {
        LOGGER.info("START - getUser");

        // authHeader = "Basic dXNlcjpwd2Q="
        // Remove "Basic " prefix
        String encodedCredentials = authHeader.substring("Basic ".length());
        LOGGER.debug("encodedCredentials={}", encodedCredentials);

        // Decode Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        LOGGER.debug("decodedString={}", decodedString);

        // decodedString = "user:pwd" → get only username (before colon)
        String user = decodedString.substring(0, decodedString.indexOf(":"));
        LOGGER.debug("user={}", user);

        LOGGER.info("END - getUser");
        return user;
    }

    // Generate JWT token for given user
    private String generateJwt(String user) {
        LOGGER.info("START - generateJwt");

        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        // Set token issue time as current time
        builder.setIssuedAt(new Date());
        // Set token expiry as 20 minutes from now
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(key, SignatureAlgorithm.HS256);

        String token = builder.compact();
        LOGGER.debug("token={}", token);

        LOGGER.info("END - generateJwt");
        return token;
    }
}
