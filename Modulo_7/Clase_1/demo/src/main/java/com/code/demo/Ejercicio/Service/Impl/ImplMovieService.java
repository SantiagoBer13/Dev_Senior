package com.code.demo.Ejercicio.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.demo.Ejercicio.Entity.Movie;
import com.code.demo.Ejercicio.Entity.Dto.MovieRequestDTO;
import com.code.demo.Ejercicio.Entity.Dto.MovieResponseDTO;
import com.code.demo.Ejercicio.Repository.MovieRepository;
import com.code.demo.Ejercicio.Service.MovieService;
import com.code.demo.Exception.Exceptions.MovieAlreadyExistsException;
import com.code.demo.Exception.Exceptions.ResourceNotFoundException;

@Service
public class ImplMovieService implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieResponseDTO createMovie(MovieRequestDTO movieDto) {
        Optional<Movie> movie = movieRepository.findByTitle(movieDto.getTitle());
        if(movie.isPresent()){
            throw new MovieAlreadyExistsException(movieDto.getTitle());
        }
        return MovieToMovieResponseDto(movieRepository.save(MovieResponseDtoToMovie(movieDto)));
    }

    @Override
    public MovieResponseDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return MovieToMovieResponseDto(movie);
    }

    @Override
    public List<MovieResponseDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(movie -> MovieToMovieResponseDto(movie)).toList();
    }

    @Override
    public MovieResponseDTO updateMovie(Long id, MovieRequestDTO movieDto) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        movie.setGenre(movieDto.getGenre());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setImdbRating(movieDto.getImdbRating());

        Movie saved = movieRepository.save(movie);
        return MovieToMovieResponseDto(saved);
    }

    @Override
    public void deleteMovie(Long id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        movieRepository.delete(movie);
    }

    public Movie MovieResponseDtoToMovie(MovieRequestDTO movieRequestDTO){
        Movie movie = new Movie(movieRequestDTO.getTitle(), movieRequestDTO.getDirector(),movieRequestDTO.getGenre(),movieRequestDTO.getReleaseYear(),movieRequestDTO.getImdbRating());
        return movie;
    }

    public MovieResponseDTO MovieToMovieResponseDto(Movie movie){
        MovieResponseDTO movieResponseDTO = new MovieResponseDTO(movie.getTitle(), movie.getDirector(),movie.getGenre(),movie.getReleaseYear(),movie.getImdbRating());
        return movieResponseDTO;
    }

}