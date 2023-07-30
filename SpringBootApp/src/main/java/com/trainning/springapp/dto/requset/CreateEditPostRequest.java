package com.trainning.springapp.dto.requset;

import lombok.Data;

@Data
public class CreateEditPostRequest {
    private String Title;
    private String Content;
    private boolean HasMedia;
}
