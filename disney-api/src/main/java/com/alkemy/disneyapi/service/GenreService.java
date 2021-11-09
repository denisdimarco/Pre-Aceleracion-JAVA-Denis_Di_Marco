package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.exception.ParamNotFound;

import java.util.List;

public interface GenreService {

    //GET
    List<GenreDTO> getAllGenres();

    GenreDTO getGenreById(Long genreId);

    //SAVE
    GenreDTO saveGenreToDB(GenreDTO genreDto);

    //UPDATE
    GenreDTO updateGenreInDB(Long id, GenreDTO genreNewData);

    //DELETE
    void deleteGenreInDB(Long id);
}
