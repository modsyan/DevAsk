package com.trainning.springapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.boot.model.internal.XMLContext;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long EntityId;
    private String EntityType; //TODO: Enum Validation
    @Setter
    private byte[] Image;
    @CreatedDate
    private Date CreatedAt;
    @LastModifiedDate
    private Date UpdatedAt; //TODO: automatically updated value
}
