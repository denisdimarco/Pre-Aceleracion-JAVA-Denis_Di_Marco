package com.alkemy.disneyapi.controller;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("continentes")
public class GenreController {

    //TODO create GenreService class
    @Autowired
    private GenreService genreService;

    //TODO GET /genre
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        List<GenreDTO> genres = genreService.getAllGenres();
        return ResponseEntity.ok().body(genres);
    }

    //TODO GET /genre/{id}

    //TODO POST /genre

    //TODO PUT /genre/{id}

    //TODO DELETE /genre/{id}






}
