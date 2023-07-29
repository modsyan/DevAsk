package com.trainning.springapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.boot.model.internal.XMLContext;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String EntityId;
    private String EntityType; //TODO: Enum Validation
    @Setter
    private byte[] Image;
    private Date CreatedAt;
    @Setter
    private Date UpdatedAt; //TODO: automatically updated value
}
