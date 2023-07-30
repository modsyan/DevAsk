package com.trainning.springapp.model;

import com.trainning.springapp.enums.ReactType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor

@AllArgsConstructor
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long UserId;
    private Long PostId;
    private ReactType reactType;
    @CreatedDate
    private Date CreatedAt;
}
