package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.entity.MovieEntity;

import java.util.List;

public interface MovieService {
    //GET
    List<MovieBasicDTO> getAllMoviesLite();

    MovieDTO getMovieDetailsById(Long id);

    //GET BY FILTERS
    List<MovieDTO> getMoviesByFilters(String title, String genre, String order);

    //SAVE
    MovieDTO saveNewMovie(MovieDTO movieDTO);

    void addCharacterToMovie(Long movieId, Long characterId);

    //UPDATE
    MovieDTO updateMovieById(Long id, MovieDTO movieNewData);

    //DELETE
    void deleteMovie(Long id);

    void deleteCharacterFromMovie(Long movieId, Long characterId);





}
