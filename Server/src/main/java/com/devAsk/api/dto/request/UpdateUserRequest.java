package com.devAsk.api.dto.request;

import lombok.Data;

public @Data class UpdateUserRequest {
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Bio;
    private byte[] ProfilePicture;
}
