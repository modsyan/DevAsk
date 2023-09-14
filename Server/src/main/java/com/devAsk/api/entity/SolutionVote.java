package com.devAsk.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "solution_votes")
@NoArgsConstructor
@AllArgsConstructor
public class SolutionVote {

    @Id
    @ManyToOne
    private Solution solution;

    @Id
    @ManyToOne
    private User user;
}
