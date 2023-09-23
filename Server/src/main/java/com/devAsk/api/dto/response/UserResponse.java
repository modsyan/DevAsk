package com.devAsk.api.dto.response;

import com.devAsk.api.entity.File;
import com.devAsk.api.entity.Question;
import com.devAsk.api.entity.Solution;
import com.devAsk.api.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private long id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private File profilePicture;

}
