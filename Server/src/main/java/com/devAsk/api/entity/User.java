package com.devAsk.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


//@Table(name = "Users")
@Data
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String hashedPassword;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String bio;

    @OneToOne
    private File profilePicture;

    @OneToMany
    private List<Question> questions;

    @OneToMany
    private List<Solution> solutions;

    @DateTimeFormat
    @Setter(AccessLevel.NONE)
    @CreatedDate
    private Date createdAt;

    @DateTimeFormat
    @Setter(AccessLevel.NONE)
    @LastModifiedDate
    private Date updateAt;

}