package com.trainning.springapp.dto.response;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private long Id;
    private long UserId;
    private String Title;
    private String Content;
    private boolean HasMedia;
    private Date CreatedAt;
    private Date UpdatedAt;
}
