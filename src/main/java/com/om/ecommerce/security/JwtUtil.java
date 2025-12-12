package com.om.ecommerce.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String email,String role){
        return Jwts.builder()
                .setSubject(email)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*10))
                .signWith(key)
                .compact();
    }

    //Extract Username
    public String extractEmail(String token){
        return extractAllClaims(token).getSubject();
    }

    //ExtractRole
    public String extractRole(String token){
        return (String)extractAllClaims(token).get("role", String.class);
    }

    //Validate Token
    public boolean isTokenExpired(String token){
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String email){
        return (extractEmail(token).equals(email) && !isTokenExpired(token));
    }

    //helper to parse claim itseems
        private Claims extractAllClaims(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }


}
