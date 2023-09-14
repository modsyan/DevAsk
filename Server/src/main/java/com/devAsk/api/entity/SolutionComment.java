package com.devAsk.api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "solution_comments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolutionComment {

    @Id
    @ManyToOne
    private Solution solution;

    @Id
    @ManyToOne
    private Comment comment;

}

