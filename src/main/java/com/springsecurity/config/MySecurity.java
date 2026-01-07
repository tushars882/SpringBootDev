package com.springsecurity.config;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class MySecurity{
	
	@Bean
	public SecurityFilterChain scfc(HttpSecurity http) throws Exception {
		http.csrf(customizer -> customizer.disable());			//disable csrf token
//		http.authorizeHttpRequests(request -> request.anyRequest().permitAll());
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		http.httpBasic(org.springframework.security.config.Customizer.withDefaults()); //enables http basic auth
		
		return http.build();
		
	}
	
}
