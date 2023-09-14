package com.devAsk.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "question_votes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionVote {

    @Id
    @ManyToOne
    private Question question;

    @Id
    @ManyToOne
    private User user;

}