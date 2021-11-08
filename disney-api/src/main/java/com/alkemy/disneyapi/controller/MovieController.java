package com.alkemy.disneyapi.controller;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    //7. LISTADO DE PELICULAS BASICO OK!
    //  GET /movies (Debera mostrar solamente los campos imagen, titulo y fecha de creacion)
    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAllMoviesLite() {
        List<MovieBasicDTO> moviesListLite = movieService.getAllMoviesLite();
        return ResponseEntity.ok(moviesListLite);
    }

    //8. Detalle de Pelicula con personajes asociados OK!
    //  GET /movies/{id} (Buscar una sola pelicula y devuelve todos los campos de las peliculas junto con los personajes asociados)
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieDetailsById(@PathVariable Long id) {
        MovieDTO movieDto = movieService.getMovieDetailsById(id);
        return ResponseEntity.ok(movieDto);
    }

    //TODO 9. CREACION, EDICION Y ELIMINACION DE PELICULA.

    //  POST /movies OK!
        @PostMapping
        public ResponseEntity<MovieDTO> postNewMovie(@RequestBody MovieDTO movieDto) {
            MovieDTO savedMovie = movieService.saveNewMovie(movieDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        }

    // PUT /movies/{id} (update movie by ID) OK!
        @PutMapping("/{id}")
        public ResponseEntity<MovieDTO> updateMovieById(@PathVariable Long id, @RequestBody MovieDTO movieNewData) {
            MovieDTO updatedMovie = movieService.updateMovieById(id, movieNewData);
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedMovie);
        }

    //  DELETE /movies/{id} (remove movie byId)
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
            movieService.deleteMovie(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }


    //  TODO DELETE /movies/{genreId}/character/{characterId} (remove character from movie by ID)
        @DeleteMapping("/{movieId}/character/{characterId}")
        public ResponseEntity<Void> removeCharacterFromMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
            movieService.deleteCharacterFromMovie(movieId, characterId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }


    //TODO 10. BUSQUEDA DE PELICULAS (por filtros)
    // /movies?name=name
    // /movies?genre=genderId
    // /movies?order=ASC | DESC












}
