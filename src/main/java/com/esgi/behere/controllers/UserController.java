package com.esgi.behere.controllers;

import com.esgi.behere.model.User;
import com.esgi.behere.dao.UserRepository;
import com.esgi.behere.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    /** Get All users from a user **/
    @GetMapping("/users")
    List<User> all() {
        return (List<User>) repository.findAll();
    }

    /** Post user **/
    @PostMapping(value = "/users")
    public static ResponseEntity<User> addUser(@Valid @RequestBody User newUser) {
        UserController.addUser(newUser);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    /** Get one party **/
    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        throw new BeerNotFoundException("aaaaaaaaaaaaaaaa");
    }

    @PutMapping("/users/{id}")
    User replaceUser(@Valid @RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return repository.save(newUser);
                })
                .orElseThrow(() -> new BeerNotFoundException("id"));
    }

    /** Get one party **/
    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
