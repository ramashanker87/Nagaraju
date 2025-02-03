package com.naga.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails doctor = User.withUsername("doctor")
                .password(passwordEncoder()
                        .encode("password1"))
                .roles("Doctor")
                .build();
        UserDetails patient = User.withUsername("patient")
                .password(passwordEncoder()
                        .encode("password1"))
                .roles("PATIENT")
                .build();
        return new InMemoryUserDetailsManager(doctor, patient);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/get/patient").hasRole("PATIENT")
                        .requestMatchers("/create/patient").hasRole("DOCTOR")
                        .requestMatchers("/update/patient").hasRole("DOCTOR")
                        .requestMatchers("/delete/patient").hasRole("DOCTOR")
                        .requestMatchers("/get/all/patient").hasRole("DOCTOR")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
