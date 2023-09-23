package com.devAsk.api.dto.response;

import com.devAsk.api.entity.User;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private long id;
//    private long userId;
    private UserResponse user;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}
