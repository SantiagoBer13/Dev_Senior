package com.code.demo.Ejercicio.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.demo.Ejercicio.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByDirectorContainingIgnoreCase(String director);
    List<Movie> findByGenreIgnoreCase(String genre);
    Optional<Movie> findByTitle(String title);

}
