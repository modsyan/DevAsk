package com.trainning.springapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private String UserId;
    private String Title;
    private String Content;
    private boolean HasMedia;
    private Date CreatedAt;
    private Date UpdatedAt;

    public Post(){}
    public Post(String userId, String title, String content) {
        this(userId, title, content, false);
    }
    public Post(String userId, String title, String content, boolean hasMedia) {
        UserId = userId;
        Title = title;
        Content = content;
        HasMedia = hasMedia;
        CreatedAt = new Date();
        UpdatedAt = new Date();
    }

    public String Id() {
        return Id;
    }
    public String UserId() {
        return UserId;
    }
    public String Title() {
        return Title;
    }
    public String Content() {
        return Content;
    }
    public boolean HasMedia() {
        return HasMedia;
    }
    public Date CreatedAt() {
        return CreatedAt;
    }
    public Date UpdatedAtk() {
        return UpdatedAt;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public void setHasMedia(boolean hasMedia) {
        HasMedia = hasMedia;
    }
    public void setContent(String content) {
        Content = content;
    }
    public void setUpdatedAt() {
        UpdatedAt = new Date();
    }
}