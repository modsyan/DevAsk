package com.devAsk.api.dto.request;

import lombok.Data;

@Data
public class CreateEditQuestionRequest {
    private String title;
    private String content;
}
