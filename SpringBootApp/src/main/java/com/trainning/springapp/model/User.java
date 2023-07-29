package com.trainning.springapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


//@Table(name = "Users")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int Id;

    @Column(nullable = false)
    private String Firstname;
    @Column(nullable = false)
    private String Lastname;
    @Column(nullable = false)
    private String HashedPassword;
    @Column(unique = true)
    private String Username;
    @Column(unique = true)
    private String Email;
    private String Bio;
    @Column(nullable = true)
    private byte[] ProfilePicture;
    @DateTimeFormat
    @Setter(AccessLevel.NONE)
    private Date CreatedAt;
    @DateTimeFormat
    @Setter(AccessLevel.NONE)
    private Date UpdateAt;
    //TODO: Update UpdatedAt Trigger
}