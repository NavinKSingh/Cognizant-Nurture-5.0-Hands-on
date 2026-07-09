package com.cognizant.springlearn.security;

import java.security.Key;
import java.util.Base64;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * Centralizes JWT secret-key handling so AuthenticationController (which
 * signs tokens) and JwtAuthorizationFilter (which verifies them) always use
 * the exact same key.
 */
public final class JwtUtil {

    // NOTE: hardcoded secret is fine for this learning hands-on only.
    // In a real application, load this from an environment variable /
    // secrets manager, never commit it to source control.
    private static final String SECRET_KEY = "secretkeysecretkeysecretkeysecretkey1234";

    public static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS256;

    private JwtUtil() {
    }

    public static Key signingKey() {
        String base64Key = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(base64Key));
    }
}
