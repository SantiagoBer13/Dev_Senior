package com.code.demo.Ejercicio.Service;

import java.util.List;

import com.code.demo.Ejercicio.Entity.Dto.MovieRequestDTO;
import com.code.demo.Ejercicio.Entity.Dto.MovieResponseDTO;

public interface MovieService {
    MovieResponseDTO createMovie(MovieRequestDTO movieDto);
    MovieResponseDTO getMovieById(Long id);
    List<MovieResponseDTO> getAllMovies();
    MovieResponseDTO updateMovie(Long id, MovieRequestDTO movieDto);
    void deleteMovie(Long id);
}
