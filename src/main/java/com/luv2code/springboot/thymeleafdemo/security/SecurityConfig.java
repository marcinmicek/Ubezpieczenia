package com.luv2code.springboot.thymeleafdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails jaro = User.builder()
                .username("jaro")
                .password("{noop}jaro123")
                .roles("USER")
                .build();

        UserDetails tomasz = User.builder()
                .username("tomasz")
                .password("{noop}tomasz123")
                .roles("USER", "MANAGER")
                .build();

        UserDetails marcin = User.builder()
                .username("marcin")
                .password("{noop}marcin123")
                .roles("USER", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(jaro, tomasz, marcin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("USER")
                                .requestMatchers("/policies/showChooseFirstNameForm/**").hasAnyRole("MANAGER","ADMIN")
                                .requestMatchers("/policies/showChooseLastNameForm/**").hasAnyRole("MANAGER","ADMIN")
                                .requestMatchers("/policies/showChooseMonthForm/**").hasAnyRole("MANAGER","ADMIN")
                                .requestMatchers("/policies/showFormForAdd/**").hasRole("ADMIN")
                                .requestMatchers("/policies/showFormForUpdate/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );

        return http.build();
    }
}
