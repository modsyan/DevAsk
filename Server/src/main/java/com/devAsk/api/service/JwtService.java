package com.devAsk.api.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    public <T> T extractClaim(String token, Function<Claims, T> ClaimResolver);

    public String getUsernameClaims(String token);

    public String generateToken(UserDetails userDetails);

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    public boolean isTokenValid(String token, UserDetails userDetails);

    public String generateRefreshToken(UserDetails userDetails);

    public boolean isTokenExpired(String token);
}
