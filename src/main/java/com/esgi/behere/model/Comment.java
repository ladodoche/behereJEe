package com.esgi.behere.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
public class Comment {
    private @Id @GeneratedValue Long id;

    //@NotNull(message = "Le commentaire n'est pas rataché à une bière")
    private Long id_beer;

    //@Size(min = 1, max = 255, message = "Le commentaire ne peut pas dépasser les 255 caractères")
    //@NotBlank(message = "Le commentaire ne peut pas être vide")
    private String comment;

    private Comment() { }

    public Comment(Long id_beer, String comment) {
        super();
        this.id_beer = id_beer;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
