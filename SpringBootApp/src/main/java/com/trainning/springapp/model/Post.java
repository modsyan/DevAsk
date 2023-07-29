package com.trainning.springapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int UserId;
    @Setter
    private String Title;
    @Setter
    private String Content;
    @Setter
    private boolean HasMedia;
    private Date CreatedAt;
    @Setter
    private Date UpdatedAt;
}