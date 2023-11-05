package com.project.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AcutatorSecurityConfig {

	/*
	 * Actuator URL = http://localhost:8080/actuator/env 
	 * Common actuator endpoints = /env, /metrics, /health, /beans, /mappings
	 */

	/*
	 * This method is to secure the actuator management endpoints to particular role
	 * ADMIN. This method authenticates the request and only user admin is allowed.
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/actuator/**").hasRole("ADMIN").anyRequest().authenticated().and()
				.httpBasic().and().csrf().disable();
		return http.build();
	}
}
