package com.alkemy.disneyapi.controller;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.service.MovieService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //  PUT /movies/{id} (update movie by ID)
    //  DELETE /movies/{id} (remove country byId)
    //  DELETE /movies/{genreId}/character/{characterId} (remove character from movie by ID)

    //TODO 10. BUSQUEDA DE PELICULAS (por filtros)
    // /movies?name=name
    // /movies?genre=genderId
    // /movies?order=ASC | DESC


    //NO PEDIDO POR EL CHALLENGE
    //GET /movies/details (Devuelve todos los campos de TODAS las peliculas junto con los personajes asociados)











}
