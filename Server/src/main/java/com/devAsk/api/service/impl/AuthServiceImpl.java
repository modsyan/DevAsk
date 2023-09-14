package com.devAsk.api.service.impl;

import com.devAsk.api.dto.request.LoginUserRequest;
import com.devAsk.api.dto.request.RegisterUserRequest;
import com.devAsk.api.dto.response.AuthUserResponse;
import com.devAsk.api.entity.User;
import com.devAsk.api.mapper.AuthMapper;
import com.devAsk.api.repository.UserRepository;
import com.devAsk.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

import org.springframework.security.crypto.bcrypt.BCrypt;

import static org.springframework.scheduling.annotation.AsyncResult.*;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthMapper _authMapper;
    private UserRepository _userRepository;

    @Autowired
    public void AuthService(UserRepository userRepository) {
        _authMapper = AuthMapper.INSTANCE;
        _userRepository = userRepository;
    }

    @Async
    @Override
    public Future<AuthUserResponse> Register(RegisterUserRequest dto) {

        String hashedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        dto.setPassword(hashedPassword);

        User user = _authMapper.RegisterUserRequestToUser(dto);
        User createdUser = _userRepository.save(user);
        AuthUserResponse userResponse = _authMapper.UserToAuthUserResponse(createdUser);

        return forValue(userResponse);
    }

    @Async
    @Override
    public Future<AuthUserResponse> Login(LoginUserRequest dto) {

//        User user = _userRepository.findByEmail()

        return null;
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
