package com.smartwaste.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for POST
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // Allow API calls
                .anyRequest().permitAll()
            );

        return http.build();
    }
}