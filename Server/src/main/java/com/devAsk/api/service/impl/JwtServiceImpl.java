package com.devAsk.api.service.impl;

import com.devAsk.api.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${application.security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.token.expiration-in-seconds}")
    private int expirationInSeconds;

    @Value("${application.security.jwt.token.audience}")
    private String audience;

    @Value("${application.security.jwt.token.issuer}")
    private String Issuer;

    @Value("${application.security.jwt.token.refresh-token.expiration-in-seconds}")
    private int refreshTokenExpirationInSeconds;

    public <T> T extractClaim(String token, Function<Claims, T> ClaimResolver) {
        final Claims claims = extractAllClaims(token);
        return ClaimResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, expirationInSeconds);
    }

    public String generateToken(
            Map<String, Object> extraClaims, UserDetails userDetails
    ) {
        return buildToken(extraClaims, userDetails, expirationInSeconds);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, refreshTokenExpirationInSeconds);
    }

    private String buildToken(
            Map<String, Object> extraClaims, UserDetails userDetails, long expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        var username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
