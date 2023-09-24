package com.devAsk.api.repository;

import com.devAsk.api.entity.Solution;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    public List<Solution> findSolutionsByQuestionId(long questionId);
}
