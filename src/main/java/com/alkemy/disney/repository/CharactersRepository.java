package com.alkemy.disney.repository;

import com.alkemy.disney.model.Characters;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CharactersRepository extends CrudRepository<Characters, Integer> {

    @Query("select c.image, c.name from Characters c")
    Iterable<Characters> getCharacters();

    @Query("select c, m.title from Movies m, Characters as c inner join c.movies")
    Iterable<Characters> getCharactersWMovie();

    @Query("from Characters where name like %:name%")
    Iterable<Characters> getCharactersByNameLike(@Param("name") String name);

    @Query("from Characters where age=:age")
    Iterable<Characters> getCharactersByAge(@Param("age") int age);

    @Query("from Characters where name like %:name% and weight=:weight")
    Iterable<Characters> getCharactersByNameAndWeight(@Param("name") String name, @Param("weight") int weight);
}
