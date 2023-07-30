package com.trainning.springapp.dto.response;

import lombok.Data;

import java.util.Date;

public @Data class CreateEditUserResponse {
    private long Id;
    private long UserId;
    private String Title;
    private String Content;
    private boolean HasMedia;
    private Date CreatedAt;
    private Date UpdatedAt;
}
