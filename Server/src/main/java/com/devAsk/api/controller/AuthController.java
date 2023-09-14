package com.devAsk.api.controller;

import com.devAsk.api.dto.request.LoginUserRequest;
import com.devAsk.api.dto.request.RegisterUserRequest;
import com.devAsk.api.model.ApiResult;
import com.devAsk.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    private final AuthService _authService;

    @Autowired
    public AuthController(AuthService authService) {
        _authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResult> Register(@RequestBody(required = false) RegisterUserRequest dto) {
        var createdUser = _authService.Register(dto);
        return ApiResult.Ok("Logged Successfully", createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResult> Login(@RequestBody(required = false) LoginUserRequest dto) {
        var loggedUser = _authService.Login(dto);
        return ApiResult.Ok("Logged Successfully", loggedUser);
    }

    @PostMapping("/SendResetPassword")
    public ResponseEntity<ApiResult> SendResetPassword(@RequestBody(required = false) String email) {
        _authService.SendResetPassword(email);
        return ApiResult.Ok("Check your email inbox");
    }

    @PostMapping("/ResetPassword")
    public ResponseEntity<ApiResult> SendResetPassword(@RequestBody(required = false) String token, @RequestBody(required = false) String password) {
         _authService.ResetPassword(token, password);
        return ApiResult.Ok("Check your email inbox");
    }

    @PostMapping("/SendEmailConfirmation")
    public ResponseEntity<ApiResult> SendEmailConfirmation(@RequestBody(required = false) String email) {
        _authService.SendEmailConfirmation(email);
        return ApiResult.Ok("Check your email inbox");
    }
}
