package com.cognizant.springlearn.security;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Hands on doc 5: "Authorize based on JWT".
 *
 * NOTE: uses jjwt 0.11.5's builder-style parser API
 * (Jwts.parserBuilder()...build().parseClaimsJws()) instead of the
 * deprecated single-arg Jwts.parser().setSigningKey(String) used in the
 * original hands-on (written for jjwt 0.9.0). Functionally identical:
 * validates the signature and reads the "sub" (subject/username) claim.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("Start");
        LOGGER.debug("{}", authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.info("Start");
        String header = req.getHeader("Authorization");
        LOGGER.debug("Authorization header: {}", header);

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
        LOGGER.info("End");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(JwtUtil.signingKey())
                    .build()
                    .parseClaimsJws(token.replace("Bearer ", ""));
            String user = jws.getBody().getSubject();
            LOGGER.debug("Token subject: {}", user);
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        } catch (JwtException ex) {
            LOGGER.warn("Invalid JWT: {}", ex.getMessage());
            return null;
        }
        return null;
    }
}
