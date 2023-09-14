package com.devAsk.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
//@Table(name = "Comments")
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @OneToOne
    private User User;

    @Setter
    private String Content;

    @CreatedDate
    private Date CreatedAt;

    @LastModifiedDate
    private Date UpdatedAt;
}
