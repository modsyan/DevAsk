package com.devAsk.api.service;

import com.devAsk.api.dto.request.RegisterUserRequest;
import com.devAsk.api.dto.request.LoginUserRequest;

import com.devAsk.api.dto.response.AuthUserResponse;

import java.util.concurrent.Future;

public interface AuthService {

    Future<AuthUserResponse> Register(RegisterUserRequest dto);

    Future<AuthUserResponse> Login(LoginUserRequest dto);

    void SendResetPassword(String email);

    void ResetPassword(String token, String password);

    void SendEmailConfirmation(String email);

}
