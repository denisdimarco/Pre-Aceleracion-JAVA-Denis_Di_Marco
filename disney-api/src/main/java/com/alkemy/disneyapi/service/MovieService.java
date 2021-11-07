package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.MovieBasicDTO;

import java.util.List;

public interface MovieService {
    List<MovieBasicDTO> getAllMoviesLite();
}
