package com.devAsk.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String firstname;
    private String lastname;
    private String password;
    private String username;
    private String email;
    private String bio;
//    private IFormFile profilePicture;
}
