package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieBasicDTO> getAllMoviesLite();

    MovieDTO saveNewMovie(MovieDTO movieDTO);
}
