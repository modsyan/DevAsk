package com.devAsk.api.dto.request;

import lombok.Data;

public @Data class CreateEditUserRequest {
    private String Firstname;
    private String Lastname;
    private String Password;
    private String Username;
    private String Email;
    private String Bio;
    private byte[] ProfilePicture;
}