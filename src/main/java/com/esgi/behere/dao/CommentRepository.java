package com.esgi.behere.dao;

import com.esgi.behere.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    //List<Comment> findById_beer(final Long id);
}