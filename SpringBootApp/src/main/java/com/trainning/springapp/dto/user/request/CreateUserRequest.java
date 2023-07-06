package com.trainning.springapp.dto.user.request;

import jakarta.persistence.Column;
import lombok.Data;

public @Data class CreateUserRequest {
    private String Firstname;
    private String Lastname;
    private String Password;
    private String Username;
    private String Email;
    private String Bio;
    private byte[] ProfilePicture;
}
