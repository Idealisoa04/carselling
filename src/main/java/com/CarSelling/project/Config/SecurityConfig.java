package com.CarSelling.project.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private  JwtAuthFilter jwtAuthFilter;
        @Autowired
        private  AuthenticationProvider authenticationProvider;
        

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                return http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers("/api/usercontroller/signin").permitAll()
                                                .requestMatchers("/api/usercontroller/login").permitAll()
                                                .requestMatchers("/api/usercontroller/test").permitAll()
                                                .requestMatchers("/api/annoncecontroller/annonces").permitAll()
                                                .requestMatchers("/api/annoncecontroller/annonce/**").permitAll()
                                                .requestMatchers("/api/categoriecontroller/categories").permitAll()
                                                .requestMatchers("/api/modelcontroller/models").permitAll()
                                                .requestMatchers("/api/marquecontroller/marques").permitAll()
                                                .requestMatchers("/api/recherchecontroller/search").permitAll()
                                                .requestMatchers("/api/messagecontroller/saveIdannonce").permitAll()
                                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                                .anyRequest().authenticated())
                                .sessionManagement(sessionManagement -> sessionManagement
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                                .build();
        }

//         @Bean
//         public CorsFilter corsFilter() {
//         CorsConfiguration corsConfiguration = new CorsConfiguration();
//         corsConfiguration.addAllowedOrigin("*"); // Ajoutez ici votre domaine spécifique
//         corsConfiguration.addAllowedMethod("*");
//         corsConfiguration.addAllowedHeader("*");
//         corsConfiguration.setAllowCredentials(true);

//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", corsConfiguration);

//         return new CorsFilter(source);
//     }

}
