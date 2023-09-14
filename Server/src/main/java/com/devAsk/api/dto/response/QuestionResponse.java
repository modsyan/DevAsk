package com.devAsk.api.dto.response;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private long Id;
    private long UserId;
    private String Title;
    private String Content;
    private boolean HasMedia;
    private Date CreatedAt;
    private Date UpdatedAt;
}
