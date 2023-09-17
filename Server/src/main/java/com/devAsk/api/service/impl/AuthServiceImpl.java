package com.devAsk.api.service.impl;

import com.devAsk.api.dto.request.LoginUserRequest;
import com.devAsk.api.dto.request.RegisterUserRequest;
import com.devAsk.api.dto.response.AuthUserResponse;
import com.devAsk.api.enums.Role;
import com.devAsk.api.mapper.AuthMapper;
import com.devAsk.api.mapper.UserMapper;
import com.devAsk.api.model.wrapper.WithToken;
import com.devAsk.api.repository.UserRepository;
import com.devAsk.api.service.AuthService;
import com.devAsk.api.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

import static org.springframework.scheduling.annotation.AsyncResult.*;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthMapper _authMapper;
    private final UserMapper _userMapper;
    private final JwtService _jwtService;
    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;
    private final AuthenticationManager _authenticationManager;

    @Async
    @Override
    public Future<AuthUserResponse> Register(RegisterUserRequest dto) {

        var user = _authMapper.RegisterUserRequestToUser(dto);
        user.setPassword(_passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.USER);
        var createdUser = _userRepository.save(user);

        var userDetail = _userMapper.UserToUserDetailResponse(user);

        var jwtToken = _jwtService.generateToken(createdUser);

        var authResponse = AuthUserResponse
                .builder()
                .user(userDetail)
                .Token(jwtToken)
                .build();

        return forValue(authResponse);
    }

    @Async
    @Override
    public Future<AuthUserResponse> Login(LoginUserRequest dto) {

        _authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLoginIdentifier(),
                dto.getPassword()));

        var user = _userRepository
                .findByEmail(dto.getLoginIdentifier())
                .orElseThrow();

        var jwtToken = _jwtService.generateToken(user);

        var userDetail = _userMapper.UserToUserDetailResponse(user);

        return forValue(AuthUserResponse
                .builder()
                .user(userDetail)
                .Token(jwtToken)
                .build());
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
}
