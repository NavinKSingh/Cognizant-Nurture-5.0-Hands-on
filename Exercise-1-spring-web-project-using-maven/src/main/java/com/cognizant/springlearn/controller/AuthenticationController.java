package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.security.JwtUtil;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

/**
 * Hands on doc 5: "Create authentication service that returns JWT",
 * "Read Authorization header and decode the username and password",
 * "Generate token based on the user".
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private static final long TOKEN_VALIDITY_MS = 1_200_000; // 20 minutes

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("authHeader: {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Decoding Authorization header");
        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decoded = new String(decodedBytes);
        String user = decoded.substring(0, decoded.indexOf(":"));
        LOGGER.debug("Decoded user: {}", user);
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.debug("Generating JWT for user: {}", user);
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY_MS));
        builder.signWith(JwtUtil.signingKey(), JwtUtil.ALGORITHM);
        return builder.compact();
    }
}
