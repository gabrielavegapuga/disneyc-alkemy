package com.alkemy.disney.repository;

import com.alkemy.disney.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    @Query("select m.image, m.title, m.date_creation from Movies m")
    Iterable<Movies> getMovies();

    @Query("from Movies where title like %:title%")
    Iterable<Movies> getMoviesByNameLike(@Param("title") String title);

    @Query("from Movies where title like %:title% and id_genre=:id_genre order by date_creation desc")
    Iterable<Movies> getMoviesByNameAndGenre(@Param("title") String title,
                                             @Param("id_genre") int id_genre);



}
