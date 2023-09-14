package com.devAsk.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@Builder
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @Setter
    private String title;

    @Setter
    private String content;

    @OneToMany
    private List<QuestionComment> questionComments;

//    @OneToMany
//    private List<Comment> comments;

    @OneToMany
    private List<QuestionVote> questionVotes;

    @OneToMany
    private List<File> files;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}