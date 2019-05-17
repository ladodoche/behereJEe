package com.esgi.behere.dao;

import com.esgi.behere.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {
    //List<Comment> findById_beer(final Long id);
}