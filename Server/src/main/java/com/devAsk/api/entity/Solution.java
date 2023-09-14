package com.devAsk.api.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@Builder
@Table(name = "solutions")
@NoArgsConstructor
@AllArgsConstructor
public class Solution {

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
    private List<QuestionComment> solutionComments;

    @OneToMany
    private List<QuestionVote> solutionVotes;

    @OneToMany
    private List<File> files;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
