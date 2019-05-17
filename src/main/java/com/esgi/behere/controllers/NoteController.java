package com.esgi.behere.controllers;

import com.esgi.behere.model.Note;
import com.esgi.behere.dao.NoteRepository;
import com.esgi.behere.Exception.BeerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NoteController {

    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    /** Get All notes from a user **/
    @GetMapping("/notes")
    List<Note> all() {
        return (List<Note>) repository.findAll();
    }

    /** Post user **/
    @PostMapping(value = "/notes")
    public static ResponseEntity<Note> addNote(@Valid @RequestBody Note newNote) {
        NoteController.addNote(newNote);
        return new ResponseEntity<Note>(newNote, HttpStatus.OK);
    }

    /** Get one party **/
    @GetMapping("/notes/{id}")
    Note one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("id"));
    }

    @PutMapping("/notes/{id}")
    Note replaceNote(@RequestBody Note newNote, @PathVariable Long id) {
        return repository.findById(id)
                .map(Note -> {
                    Note.setNote(newNote.getNote());
                    return repository.save(newNote);
                })
                .orElseThrow(() -> new BeerNotFoundException("id"));
    }

    /** Get one party **/
    @DeleteMapping("/notes/{id}")
    void deleteNote(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
