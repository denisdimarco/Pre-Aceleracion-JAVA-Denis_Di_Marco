package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.exception.ParamNotFound;

import java.util.List;

public interface GenreService {

    List<GenreDTO> getAllGenres();

    GenreDTO getGenreById(Long genreId);

    GenreDTO saveGenreToDB(GenreDTO genreDto);
}
