package com.devAsk.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devAsk.api.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
