package com.trainning.springapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private String EntityId;
    private String EntityType; // -> TODO: Enum Validation
    private byte[] ImageStored;
    private Date CreatedAt;
    private Date UpdatedAt;

    public Image(){}
    public Image(String entityId, String entityType, byte[] image) {
        EntityId = entityId;
        EntityType = entityType;
        ImageStored = image;
        CreatedAt = new Date();
        UpdatedAt = new Date();
    }

    public String Id() {
        return Id;
    }
    public String EntityId() {
        return EntityId;
    }
    public String EntityType() {
        return EntityType;
    }
    public byte[] image() {
        return ImageStored;
    }
    public Date CreatedAt() {
        return CreatedAt;
    }
    public Date UpdatedAt() {
        return UpdatedAt;
    }

    public void setImage(byte[] image) {
        ImageStored = image;
    }
    public void setUpdatedAt() {
        UpdatedAt = new Date();
    }
}
