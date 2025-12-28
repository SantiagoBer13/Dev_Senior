package com.code.demo.Ejercicio.Entity;

import org.hibernate.annotations.Collate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String director;

    @NotBlank
    @Column(nullable = false)
    private String genre;

    @JsonProperty("year_released")
    @NotNull(message = "El año de lanzamiento es obligatorio")
    @Column(nullable = false)
    private Integer releaseYear;

    @JsonProperty("imdb_score")
    @NotNull(message = "El promedio es obligatorio")
    @Column(nullable = false)
    private Double imdbRating;

    public Movie(String title, String director, String genre, Integer releaseYear, Double imdbRating){
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.imdbRating = imdbRating;
    }
}
