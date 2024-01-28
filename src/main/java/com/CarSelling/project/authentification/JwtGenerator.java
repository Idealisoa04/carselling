package com.CarSelling.project.authentification;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
    
    @Autowired
    private JwtProperties jwtProperties;

    public JwtGenerator() {
    }

    public String generateJwt(String userId, String username) {
        Date now = new Date(System.currentTimeMillis());
        Date expiration = new Date(now.getTime() + jwtProperties.getExpirationTime());
   
        return Jwts.builder()
                    .setSubject(userId) 
                    .claim("username", username)
                    .claim("id", userId)
                    .setIssuedAt(now)
                    .setExpiration(expiration)
                    .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                    .compact(); 
     }

    public JwtProperties getJwtProperties() {
        return jwtProperties;
    }

    public void setJwtProperties(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    
}
