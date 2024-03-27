package com.learning.learnspringsecurity.basic;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class BasicAuthSecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        ////       1) All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
////       2) If a request is not authenticated, use http basic
        http.httpBasic(withDefaults());

////       3) CSRF -> POST, PUT
        http.csrf(csrf -> csrf.disable());
        // OR
        //http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        var user= User.withUsername("sandy")
                .password("{noop}sandy123")
                .roles("USER")
                .build();
        var admin= User.withUsername("admin")
                .password("{noop}sandy123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager();
    }
}
