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

    //PEDIDOS POR EL CHALLENGE:

    //TODO: 7. LISTADO DE PELICULAS BASICO
    //  GET /movies (Debera mostrar solamente los campos imagen, titulo y fecha de creacion)
    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAllMoviesLite() {
        List<MovieBasicDTO> moviesListLite = movieService.getAllMoviesLite();
        return ResponseEntity.ok(moviesListLite);
    }

    //TODO: 8. Detalle de Pelicula con personajes asociados
    //  GET /movies/{id} (Buscar una sola pelicula y devuelve todos los campos de las peliculas junto con los personajes asociados)

    //TODO 9. CREACION, EDICION Y ELIMINACION DE PELICULA.

    //  POST /movies
        @PostMapping
        public ResponseEntity<MovieDTO> postNewMovie(@RequestBody MovieDTO movieDto) {
            MovieDTO savedMovie = movieService.saveNewMovie(movieDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
        }


    //  TODO PUT /movies/{id} (update movie by ID)
        @PutMapping("/{id}")
        public ResponseEntity<MovieDTO> updateMovieById(@PathVariable Long id, @RequestBody MovieDTO movieNewData) {
            MovieDTO updatedMovie = movieService.updateMovieById(id, movieNewData);
            return  ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedMovie);
        }

    //  TODO DELETE /movies/{id} (remove country byId)
    //  TODO DELETE /movies/{genreId}/character/{characterId} (remove character from movie by ID)



    //TODO 10. BUSQUEDA DE PELICULAS (por filtros)
    // /movies?name=name
    // /movies?genre=genderId
    // /movies?order=ASC | DESC


    //NO PEDIDO POR EL CHALLENGE
    //GET /movies/details (Devuelve todos los campos de TODAS las peliculas junto con los personajes asociados)











}
