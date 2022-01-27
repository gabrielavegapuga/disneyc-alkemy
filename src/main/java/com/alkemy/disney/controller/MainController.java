package com.alkemy.disney.controller;

import com.alkemy.disney.model.Characters;
import com.alkemy.disney.model.Genres;
import com.alkemy.disney.model.Movies;
import com.alkemy.disney.repository.CharactersRepository;
import com.alkemy.disney.repository.GenresRepository;
import com.alkemy.disney.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/alkemy/disney")
public class MainController {

    @Autowired
    private GenresRepository genresRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private CharactersRepository charactersRepository;

    //READ

    @GetMapping(path = "/genres/all")
    public @ResponseBody
    Iterable<Genres> getAllGenres(){
        return genresRepository.findAll();
    }


    @GetMapping(path = "/movies/all")
    public @ResponseBody
    Iterable<Movies> getAllMovies(){
        return moviesRepository.findAll();
    }


    @GetMapping(path = "/characters/all")
    public @ResponseBody
    Iterable<Characters> getAllCharacters(){
        return charactersRepository.findAll();
    }

    //CONSULTAR SOLAMENTE IMAGEN Y NOMBRE DEL PERSONAJE
    @GetMapping(path = "/characters")
    public @ResponseBody
    Iterable<Characters> getCharacters(){ return charactersRepository.getCharacters(); }

    //CONSULTAR TODA LA INFO DE PERSONAJE Y SU PELICULA RELACIONADA
    @GetMapping(path = "/characters/movie")
    public @ResponseBody
    Iterable<Characters> getCharactersWMovie(){ return charactersRepository.getCharactersWMovie(); }



    //CONSULTAR SOLAMENTE IMAGEN, TITULO Y FECHA CREACION DE PELICULA
    @GetMapping(path = "/movies")
    public @ResponseBody
    Iterable<Movies> getMovies(){ return moviesRepository.getMovies(); }

    //CONSULTAR PERSONAJE POR NOMBRE
    @GetMapping(path = "/characters/name/like/{name}")
    public @ResponseBody
    Iterable<Characters> getCharactersByNameLike(@PathVariable("name") String name){
        return charactersRepository.getCharactersByNameLike(name);
    }

    //CONSULTAR PERSONAJE POR EDAD
    @GetMapping(path = "/characters/age/{age}")
    public @ResponseBody
    Iterable<Characters> getCharactersByAge(@PathVariable("age") int age){
        return charactersRepository.getCharactersByAge(age);
    }

    //CONSULTAR PERSONAJE POR NOMBRE Y PESO
    @GetMapping(path = "/characters/name/like/{name}/weight/{weight}")
    public @ResponseBody
    Iterable<Characters> getCharactersByNameAndWeight(@PathVariable("name") String name,
                                                       @PathVariable("weight") int weight){
        return charactersRepository.getCharactersByNameAndWeight(name, weight);
    }

    //CONSULTAR PELICULA POR TITULO
    @GetMapping(path = "/movies/title/like/{title}")
    public @ResponseBody
    Iterable<Movies> getMoviesByNameLike(@PathVariable("title") String title){
        return moviesRepository.getMoviesByNameLike(title);
    }

    //CONSULTAR PELICULA POR TITULO Y ID GENERO, MUESTRA RESULTADO DE ACUERDO A LA FECHA DE
    // CREACION DE FORMA DESCENDENTE
    public @ResponseBody
    Iterable<Movies> getMoviesByNameAndGenre(@PathVariable("title") String title,
                                             @PathVariable("id_genre") int id_genre){
        return moviesRepository.getMoviesByNameAndGenre(title, id_genre);
    }

    //CREATE
    //NUEVO PERSONAJE
    @PostMapping(path = "/characters/create", consumes = "application/json", produces = "application/json")
    public Characters createCharacter(@RequestBody Characters newCharacter){
       return charactersRepository.save(newCharacter);
    }

    //NUEVA PELICULA
    @PostMapping(path = "/movies/create", consumes = "application/json", produces = "application/json")
    public Movies createMovie(@RequestBody Movies newMovie){
        return moviesRepository.save(newMovie);
    }

    //UPDATE
    //EDICION PERSONAJE
    @PutMapping(path = "/characters/update")
    public Characters updateCharacter(@RequestBody Characters updatedCharacter){
        return charactersRepository.save(updatedCharacter);
    }

    //EDICION PELICULA
    @PutMapping(path = "/movies/update")
    public Movies updateMovies(@RequestBody Movies updatedMovie){
        return moviesRepository.save(updatedMovie);
    }

    //DELETE
    //BORRAR PERSONAJE. RETORNA LOS PERSONAJES QUE NO FUERON BORRADOS.
    @DeleteMapping(path = "/characters/delete/{id_character}")
    public @ResponseBody
    Iterable<Characters> deleteCharacterById(@PathVariable("id_character") int id_character){
        charactersRepository.deleteById(id_character);
        return charactersRepository.findAll();
    }

    //BORRAR PELICULA. RETORNA LAS PELICULAS QUE NO FUERON BORRADAS.
    @DeleteMapping(path = "/movies/delete/{id_movie}")
    public @ResponseBody
    Iterable<Movies> deleteMovieById(@PathVariable("id_movie") int id_movie){
        moviesRepository.deleteById(id_movie);
        return moviesRepository.findAll();
    }

}
