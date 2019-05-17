package com.esgi.behere.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
public class Note {
    private @Id @GeneratedValue Long id;
    private Long id_beer;
    private Integer note;

    private Note() { }

    public Note(Long id_beer, Integer note) {
        super();
        this.id_beer = id_beer;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_beer() {
        return id_beer;
    }

    public void setId_beer(Long id_beer) {
        this.id_beer = id_beer;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
