package com.trainning.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Comments")
@Getter
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private String UserId;
    private String PostId;
    @Setter
    private String Content;
    @Setter
    private boolean HasMedia;
    private Date CreatedAt;
    private Date UpdatedAt;
    public Comment(){}
    public Comment(String userId, String postId, String content){
        this(userId, postId, content, false);
    }
    public Comment(String userId, String postId, String content, boolean hasMedia) {
        UserId = userId;
        PostId = postId;
        Content = content;
        HasMedia = hasMedia;
        CreatedAt = new Date();
        UpdatedAt = new Date();
    }
}
