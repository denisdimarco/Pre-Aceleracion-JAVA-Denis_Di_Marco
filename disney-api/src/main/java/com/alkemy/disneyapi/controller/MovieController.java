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

    //7. Basic Movie List
    //GET /movies (It must show only image, title and creation date fields)
    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAllMoviesLite() {
        List<MovieBasicDTO> moviesListLite = movieService.getAllMoviesLite();
        return ResponseEntity.ok(moviesListLite);
    }

    //8. Movie details with associated characters
    //GET /movies/{id} (Search a movie and show every field of the movie with associated characters)
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieDetailsById(@PathVariable Long id) {
        MovieDTO movieDto = movieService.getMovieDetailsById(id);
        return ResponseEntity.ok(movieDto);
    }

    //9. Creation, edition and deleting of a movie.
    //POST /movies
    @PostMapping
    public ResponseEntity<MovieDTO> postNewMovie(@RequestBody MovieDTO movieDto) {
        MovieDTO savedMovie = movieService.saveNewMovie(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    //POST /movies/{movieId}/character/{characterId}
    @PostMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> addCharacterToMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        movieService.addCharacterToMovie(movieId, characterId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //PUT /movies/{id} (update movie by ID) OK!
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovieById(@PathVariable Long id, @RequestBody MovieDTO movieNewData) {
        MovieDTO updatedMovie = movieService.updateMovieById(id, movieNewData);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedMovie);
    }

    //DELETE /movies/{id} (remove movie byId)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //DELETE /movies/{genreId}/character/{characterId} (remove a character from a movie by IDs)
    @DeleteMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> removeCharacterFromMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        movieService.deleteCharacterFromMovie(movieId, characterId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    //10. Search movies by filters
    // /movies?title=name
    // /movies?genre=genderId
    // /movies?order=ASC | DESC
    @GetMapping("/filters")
    public ResponseEntity<List<MovieDTO>> getMoviesDetailsByFilters (
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false, defaultValue = "ASC") String order
    )
        { List<MovieDTO> filteredMovies = movieService.getMoviesByFilters(title, genre, order);
            return ResponseEntity.ok(filteredMovies);

    }

}
