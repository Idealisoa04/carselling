package com.CarSelling.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class CarSellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSellingApplication.class, args);
	}

	

	@Bean
	CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		// Configure allowed origins, methods, headers, etc.
		config.addAllowedOrigin("http://localhost:8100"); // Replace with yourallowed
		// origins
		config.addAllowedOrigin("http://localhost:3000");
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");

		config.setAllowCredentials(true);
		source.registerCorsConfiguration("/**", config);
		CorsFilter rep = new org.springframework.web.filter.CorsFilter(source);
		return rep;
	}
}
