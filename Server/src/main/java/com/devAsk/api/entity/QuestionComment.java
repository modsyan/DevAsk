package com.devAsk.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "question_comments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionComment {

    @Id
    @ManyToOne
    private Question question;

    @Id
    @ManyToOne
    private Comment commentId;

}
