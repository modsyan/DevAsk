package com.devAsk.api.dto.response;

import lombok.Data;

import java.util.Date;

public @Data class UserResponse {
    private long Id;
    private long UserId;
    private String Title;
    private String Content;
    private Date CreatedAt;
    private Date UpdatedAt;
}
