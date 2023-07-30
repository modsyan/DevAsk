package com.trainning.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainning.springapp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
