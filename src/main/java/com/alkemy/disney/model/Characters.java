package com.alkemy.disney.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_character;

    private String image;
    private String name;
    private int age;
    private int weight;
    private String story;

    @JsonBackReference
    @ManyToMany(mappedBy = "movieCharacter")
    private Set<Movies> movies;

    public int getId_character() {
        return id_character;
    }

    public void setId_character(int id_character) {
        this.id_character = id_character;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }
}
