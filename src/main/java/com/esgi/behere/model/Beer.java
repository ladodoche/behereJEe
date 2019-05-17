package com.esgi.behere.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
public class Beer  {

    private @Id @GeneratedValue Long id;
    private /*@NotEmpty(message = "name must not be empty")*/ String name;
    private String color;
    private String origin;
    private String description;

    private Beer() {}

    public Beer(String name, String color, String origin, String description) {
        super();
        this.name = name;
        this.color = color;
        this.origin = origin;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}