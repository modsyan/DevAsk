package com.trainning.springapp.model;

import com.trainning.springapp.enums.ReactType;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor

@AllArgsConstructor
public class Reacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int UserId;
    private int PostId;
    private ReactType reactType;
    private Date CreatedAt;
}
