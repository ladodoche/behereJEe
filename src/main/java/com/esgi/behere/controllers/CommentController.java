package com.esgi.behere.controllers;

import com.esgi.behere.model.Comment;
import com.esgi.behere.dao.CommentRepository;
import com.esgi.behere.Exception.BeerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    private final CommentRepository repository;

    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    /** Get All comments from a user **/
    @GetMapping("/comments")
    List<Comment> all() {
        return (List<Comment>) repository.findAll();
    }

    /** Post user **/
    @PostMapping(value = "/comments")
    public static ResponseEntity<Comment> addComment(@Valid @RequestBody Comment newComment) {
        CommentController.addComment(newComment);
        return new ResponseEntity<Comment>(newComment, HttpStatus.OK);
    }
    /*@PostMapping("/comments")
    Comment newComment(@RequestBody Comment newComment) {
        return repository.save(newComment);
    }
*/
    /** Get one party **/
    @GetMapping("/comments/{id}")
    Comment one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException("id"));
    }

    /** Get All cards from a user **/
    /*@GetMapping("/cards/user/{id_user}")
    List<Comment> all(@PathVariable Long id_beer) {
        return repository.findById_beer(id_beer);
    }*/

    @PutMapping("/comments/{id}")
    Comment replaceComment(@RequestBody Comment newComment, @PathVariable Long id) {
        return repository.findById(id)
                .map(Comment -> {
                    Comment.setComment(newComment.getComment());
                    return repository.save(newComment);
                })
                .orElseThrow(() -> new BeerNotFoundException("id"));
    }

    /** Get one party **/
    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
