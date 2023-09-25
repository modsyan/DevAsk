package com.devAsk.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolutionDetailResponse {
    private long id;

    private UserResponse user;

    private QuestionResponse question;

    private String title;

    private String content;

    private List<CommentResponse> comments;

    private List<UserResponse> votes;

    private Date createdAt;

    private Date updatedAt;
}
