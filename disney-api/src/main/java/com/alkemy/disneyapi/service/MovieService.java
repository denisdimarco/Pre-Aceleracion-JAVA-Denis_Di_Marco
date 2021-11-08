package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.entity.MovieEntity;

import java.util.List;

public interface MovieService {
    List<MovieBasicDTO> getAllMoviesLite();

    MovieDTO getMovieDetailsById(Long id);

    MovieDTO saveNewMovie(MovieDTO movieDTO);

    MovieDTO updateMovieById(Long id, MovieDTO movieNewData);
}
