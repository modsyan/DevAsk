package com.trainning.springapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

//@Table(name = "Comments")
//@Data
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String UserId;
    private String PostId;

    @Setter
    private String Content;

    @Setter
    private boolean HasMedia;

    private Date CreatedAt;
    private Date UpdatedAt;
}
