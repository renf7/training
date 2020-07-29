package com.example.demo.config.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtTokenProvider {
    private final UserDetailsService userDetailsService;

    @Value("${jwt.token.provider.secret.key:sekret}")
    private String secretKeyValue;
    @Value("${jwt.token.provider.secret.validityInMs:1800000}")
    private Integer validityInMsValue;

    private String sekretKey;

    @PostConstruct
    protected void init() {
        sekretKey = Base64.getEncoder().encodeToString(secretKeyValue.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(String username, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(username);

        Date now = new Date();
        Date validity = new Date(now.getTime() - validityInMsValue);

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, sekretKey)
            .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(sekretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
}