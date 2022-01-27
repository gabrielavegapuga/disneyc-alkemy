package com.alkemy.disney.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_movie;

    private String image;
    private String title;
    private Date date_creation;
    private int score;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_genre", referencedColumnName = "id_genres")
    private Genres genres;



    @ManyToMany
    @JoinTable(name = "characters_x_movies",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_character"))
    private Set<Characters> movieCharacter;
    

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public Set<Characters> getMovieCharacter() {
        return movieCharacter;
    }

    public void setMovieCharacter(Set<Characters> movieCharacter) {
        this.movieCharacter = movieCharacter;
    }
}
