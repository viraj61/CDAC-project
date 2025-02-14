package com.example.demo.jwt;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.UsersDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JWTUtility {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate a secure key

    public String buildJWT(UsersDTO userDTO) {
        return Jwts.builder()
                .claim("firstname", userDTO.getName())
                .setIssuer(userDTO.getEmail())
                .setId(String.valueOf(userDTO.getGroup_id()))
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(3, ChronoUnit.HOURS)))
                .signWith(key, SignatureAlgorithm.HS256) // Sign the JWT
                .compact();
    }
}
