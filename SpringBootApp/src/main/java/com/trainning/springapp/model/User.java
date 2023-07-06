package com.trainning.springapp.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private String Id;

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

    public User() {
    }

    public User(String firstname, String lastname, String hashedPassword, String username, String email) {
        Firstname = firstname;
        HashedPassword = hashedPassword;
        Lastname = lastname;
        Username = username;
        Email = email;
        CreatedAt = new Date();
        UpdateAt = new Date();
    }
    // TODO: Update UpdatedAt Trigger
}