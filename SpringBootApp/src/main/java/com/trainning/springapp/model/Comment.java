package com.trainning.springapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

//@Table(name = "Comments")
//@Data
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private long UserId;
    private long PostId;

    @Setter
    private String Content;

    @Setter
    private boolean HasMedia;

    @CreatedDate
    private Date CreatedAt;
    @LastModifiedDate
    private Date UpdatedAt;
}
