package com.devAsk.api.dto.request;

import lombok.Data;

@Data
public class SolutionRequest {
    private long questionId;
    private String title;
    private String content;
}
