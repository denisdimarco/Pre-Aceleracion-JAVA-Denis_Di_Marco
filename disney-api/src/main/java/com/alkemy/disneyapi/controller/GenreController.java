package com.alkemy.disneyapi.controller;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    //TODO complete GenreService class
    @Autowired
    private GenreService genreService;

    //TODO GET /genres
    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        List<GenreDTO> genreDtoList = genreService.getAllGenres();
        return ResponseEntity.ok().body(genreDtoList);
    }

    //TODO GET /genres/{id}
    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long id) {
        GenreDTO genreDto = genreService.getGenreById();
        return ResponseEntity.ok().body(genreDto);
    }

    //POST /genres
    @PostMapping
    public ResponseEntity<GenreDTO> postNewGenre(@RequestBody GenreDTO genreDto) {
        GenreDTO savedGenreFromDB = genreService.saveGenreToDB(genreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGenreFromDB);
    }


    //TODO PUT /genres/{id}

    //TODO DELETE /genre/s{id}






}
