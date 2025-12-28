package com.code.demo.Ejercicio.Entity.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieRequestDTO {

    @NotBlank(message = "El título es obligatorio.")
    @Size(min = 2, max = 255, message = "El título debe tener entre 2 y 255 caracteres.")
    private String title;

    @NotBlank(message = "El director es obligatorio.")
    @Size(min = 2, max = 100, message = "El director debe tener entre 2 y 100 caracteres.")
    private String director;

    @NotBlank(message = "El género es obligatorio.")
    @Pattern(regexp = "^(Action|Comedy|Drama|Horror|Sci-Fi|Thriller|Animation|Documentary)$", message = "Género no válido. Debe ser uno de los predefinidos.")
    private String genre;

    @JsonProperty("year_released")
    @NotNull(message = "El año de lanzamiento es obligatorio.")
    @Min(value = 1888, message = "El año de lanzamiento no puede ser anterior a 1888 (inicio del cine).")
    @Max(value = 2025, message = "El año de lanzamiento no puede ser posterior al año actual (2025).")
    private Integer releaseYear;

    @JsonProperty("imdb_score")
    @DecimalMin(value = "1.0", inclusive = true, message = "La calificación IMDb debe ser al menos 1.0.")
    @DecimalMax(value = "10.0", inclusive = true, message = "La calificación IMDb no puede exceder 10.0.")
    private Double imdbRating;
}
