package com.devAsk.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDetailResponse {
    private long id;

    private UserResponse user;

    private List<SolutionResponse> solutions;

    private String title;

    private String content;

    private List<CommentResponse> comments;

    private List<UserResponse> votes;

    private Date createdAt;

    private Date updatedAt;
}
