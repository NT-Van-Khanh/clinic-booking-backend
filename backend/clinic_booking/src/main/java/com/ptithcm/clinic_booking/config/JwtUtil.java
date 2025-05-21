package com.ptithcm.clinic_booking.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret";//cấu hình trong.env
    private final long EXPIRATION = 1000 * 60 * 60 * 2;

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getAuthorities());
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }
    
    public Claims extractClaims(String token){
        try {

            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("JWT Token expired");
        } catch (MalformedJwtException e) {
            throw new RuntimeException("JWT Token malformed");
        } catch (SignatureException e) {
            throw new RuntimeException("JWT Signature validation failed");
        } catch (UnsupportedJwtException e) {
            throw new RuntimeException("JWT Token unsupported");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("JWT Token is empty or null");
        }
    }

}
