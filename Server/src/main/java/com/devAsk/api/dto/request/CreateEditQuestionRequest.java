package com.devAsk.api.dto.request;

import lombok.Data;

@Data
public class CreateEditQuestionRequest {
    private String Title;
    private String Content;
    private boolean HasMedia;
}
