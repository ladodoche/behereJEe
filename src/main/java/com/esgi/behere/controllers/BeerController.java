package com.esgi.behere.controllers;

import com.esgi.behere.model.Beer;
import com.esgi.behere.dao.BeerRepository;
import com.esgi.behere.Exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BeerController {

    private final BeerRepository repository;

    public BeerController(BeerRepository repository) {
        this.repository = repository;
    }

    /** Get All beers from a user **/
    @GetMapping("/beers")
    List<Beer> all() {
        return (List<Beer>) repository.findAll();
    }

    /** Post user **/
    @PostMapping("/beers")
    Beer newbeer(@RequestBody Beer newBeer) {
        System.out.println("ok");
        return repository.save(newBeer);
    }
    //@ResponseStatus(HttpStatus.CREATED)
    /*ResponseEntity addBeer(@Valid @RequestBody Beer newBeer) {
        System.out.println("aaaaaaaaaaaaaaa");
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Error Message");
    }*/

    /** Get one party **/
    @GetMapping("/beers/{id}")
    Beer one(@PathVariable Long id) {
        throw new BeerNotFoundException("aaaaaaaaaaaaaaaa");
        //return repository.findById(id)
                //.orElseThrow(() -> new BeerNotFoundException("a"));
    }

    @PutMapping("/beers/{id}")
    Beer replaceBeer(@Valid @RequestBody Beer newBeer, @PathVariable Long id) {
        return repository.findById(id)
                .map(beer -> {
                    beer.setName(newBeer.getName());
                    beer.setColor(newBeer.getColor());
                    beer.setOrigin(newBeer.getOrigin());
                    beer.setDescription(newBeer.getDescription());
                    return repository.save(newBeer);
                })
                .orElseThrow(() -> new BeerNotFoundException("id"));
    }

    /** Get one party **/
    @DeleteMapping("/beers/{id}")
    void deleteBeer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
