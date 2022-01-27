package com.alkemy.disney.repository;

import com.alkemy.disney.model.Genres;
import org.springframework.data.repository.CrudRepository;

public interface GenresRepository extends CrudRepository<Genres, Integer> {
}
