package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.core.userdetails.User.withUsername;

/**
 * Hands on doc 5 ("Securing RESTful Web Services with Spring Security" and
 * "Creating users and roles in Spring Security").
 *
 * NOTE: the original hands-on document targets an older Spring Boot version
 * where SecurityConfig extends WebSecurityConfigurerAdapter and overrides
 * two configure() methods. WebSecurityConfigurerAdapter is REMOVED in
 * Spring Security 6 / Spring Boot 3 — the modern replacement is exposing
 * SecurityFilterChain and AuthenticationManager as @Bean methods, which is
 * what this class does. The behaviour (in-memory admin/user accounts,
 * role-based URL authorization, JWT filter) is identical to what the
 * hands-on asks for.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Start");
        return new BCryptPasswordEncoder();
    }

    /**
     * In-memory users: admin/pwd (ROLE_ADMIN) and user/pwd (ROLE_USER).
     * IMPORTANT NOTE from the hands-on: hardcoding credentials is only for
     * learning purposes — once Spring Data JPA is introduced, credentials
     * should be validated from the database instead.
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        var admin = withUsername("admin").password(passwordEncoder.encode("pwd")).roles("ADMIN").build();
        var user = withUsername("user").password(passwordEncoder.encode("pwd")).roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager)
            throws Exception {
        http.csrf(csrf -> csrf.disable())
            .httpBasic(basic -> {})
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .addFilter(new JwtAuthorizationFilter(authenticationManager));

        return http.build();
    }
}
