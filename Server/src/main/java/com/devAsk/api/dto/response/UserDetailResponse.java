package com.devAsk.api.dto.response;

import com.devAsk.api.entity.File;
import com.devAsk.api.entity.Question;
import com.devAsk.api.entity.Solution;
import com.devAsk.api.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailResponse {

    private long Id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private String bio;

    private File profilePicture;

    private List<Question> questions;

    private List<Solution> solutions;

    private Role role;

    private Date CreatedAt;

    private Date UpdatedAt;

}
