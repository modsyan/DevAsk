package com.devAsk.api.dto.response;

import com.devAsk.api.entity.User;
import lombok.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private long id;

    private UserResponse user;

    private String title;

    private String content;

    private List<UserResponse> votes;

    private Date createdAt;
}
