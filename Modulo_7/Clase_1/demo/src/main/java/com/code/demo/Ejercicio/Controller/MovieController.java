package com.code.demo.Ejercicio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.demo.Ejercicio.Entity.Dto.MovieRequestDTO;
import com.code.demo.Ejercicio.Entity.Dto.MovieResponseDTO;
import com.code.demo.Ejercicio.Service.MovieService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/movies")
@Tag(name = "Movies", description = "Operaciones CRUD para gestión de películas")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // CREATE
    @Operation(
            summary = "Crear una película",
            description = "Crea una nueva película y retorna la película creada."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Película creada exitosamente",
                    content = @Content(schema = @Schema(implementation = MovieResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida (falló validación)"),
            @ApiResponse(responseCode = "409", description = "Ya existe una película con el mismo título")
    })
    @PostMapping("")
    public ResponseEntity<MovieResponseDTO> createMovie(
            @Valid @RequestBody MovieRequestDTO entity
    ) {
        MovieResponseDTO created = movieService.createMovie(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // READ ALL
    @Operation(
            summary = "Listar películas",
            description = "Retorna el listado de todas las películas registradas."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido exitosamente")
    })
    @GetMapping("")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {
        List<MovieResponseDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // READ ONE
    @Operation(
            summary = "Obtener película por ID",
            description = "Busca y retorna una película por su identificador."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Película encontrada",
                    content = @Content(schema = @Schema(implementation = MovieResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Película no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(
            @Parameter(description = "ID de la película", example = "1")
            @PathVariable Long id
    ) {
        MovieResponseDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    // UPDATE
    @Operation(
            summary = "Actualizar película",
            description = "Actualiza una película existente a partir de su ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Película actualizada",
                    content = @Content(schema = @Schema(implementation = MovieResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida (falló validación)"),
            @ApiResponse(responseCode = "404", description = "Película no encontrada"),
            @ApiResponse(responseCode = "409", description = "Conflicto: título duplicado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> updateMovie(
            @Parameter(description = "ID de la película", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody MovieRequestDTO entity
    ) {
        MovieResponseDTO updated = movieService.updateMovie(id, entity);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @Operation(
            summary = "Eliminar película",
            description = "Elimina una película por su ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Película eliminada"),
            @ApiResponse(responseCode = "404", description = "Película no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(
            @Parameter(description = "ID de la película", example = "1")
            @PathVariable Long id
    ) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
