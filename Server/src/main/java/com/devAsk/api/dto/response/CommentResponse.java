package com.devAsk.api.dto.response;

import com.devAsk.api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private long id;

    private UserResponse User;

    private String Content;

    private Date createdAt;

    private Date updatedAt;
}
