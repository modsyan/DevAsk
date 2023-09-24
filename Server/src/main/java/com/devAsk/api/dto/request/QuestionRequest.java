package com.devAsk.api.dto.request;

import lombok.Data;

@Data
public class QuestionRequest {
    private String title;
    private String content;
}
