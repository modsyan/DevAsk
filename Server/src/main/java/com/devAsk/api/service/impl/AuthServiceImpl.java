package com.devAsk.api.service.impl;

import com.devAsk.api.dto.request.LoginUserRequest;
import com.devAsk.api.dto.request.RegisterUserRequest;
import com.devAsk.api.dto.response.AuthUserResponse;
import com.devAsk.api.entity.Token;
import com.devAsk.api.entity.User;
import com.devAsk.api.enums.Role;
import com.devAsk.api.enums.TokenType;
import com.devAsk.api.mapper.AuthMapper;
import com.devAsk.api.mapper.UserMapper;
import com.devAsk.api.repository.TokenRepository;
import com.devAsk.api.repository.UserRepository;
import com.devAsk.api.service.AuthService;
import com.devAsk.api.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.Future;

import static org.springframework.scheduling.annotation.AsyncResult.*;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    @Async
    @Override
    public Future<AuthUserResponse> Register(RegisterUserRequest dto) {

        var user = authMapper.RegisterUserRequestToUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.USER);
        var createdUser = userRepository.save(user);

        var userDetailResponse = userMapper.UserToUserDetailResponse(user);

        var jwtToken = jwtService.generateToken(createdUser);
        saveUserToken(createdUser, jwtToken);

        var authResponse = AuthUserResponse.builder().user(userDetailResponse).token(jwtToken).build();

        return forValue(authResponse);
    }

    @Async
    @Override
    public Future<AuthUserResponse> Login(LoginUserRequest dto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getLoginIdentifier(),
                dto.getPassword()
        ));

        var user = userRepository.findByEmail(dto.getLoginIdentifier()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        var jwtRefreshToken = jwtService.generateRefreshToken(user);
        var userDetail = userMapper.UserToUserDetailResponse(user);
        return forValue(AuthUserResponse
                                .builder()
                                .user(userDetail)
                                .token(jwtToken)
                                .refreshToken(jwtRefreshToken)
                                .build());
    }




    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer "))
            return;
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail == null)
            return;
        var user = userRepository.findByEmail(userEmail).orElseThrow();
        if (!jwtService.isTokenValid(refreshToken, user))
            return;
        var accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        var authResponse = AuthUserResponse
                .builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();

        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
    }

    @Async
    @Override
    public void SendResetPassword(String email) {
    }

    @Async
    @Override
    public void ResetPassword(String token, String email) {
    }

    @Async
    @Override
    public void SendEmailConfirmation(String email) {
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllUserValidToken(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user, String token) {
        var newToken = Token
                .builder()
                .user(user)
                .token(token)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepository.save(newToken);
    }
}
