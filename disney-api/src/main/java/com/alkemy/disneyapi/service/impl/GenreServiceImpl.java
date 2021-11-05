package com.alkemy.disneyapi.service.impl;

import com.alkemy.disneyapi.mapper.GenreMapper;
import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.entity.GenreEntity;
import com.alkemy.disneyapi.repository.GenreRepository;
import com.alkemy.disneyapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreMapper genreMapper;

    @Override
    public List<GenreDTO> getAllGenres() {
        return null;
    }

    @Override
    public GenreDTO getGenreById() {
        return null;
    }

    public GenreDTO saveGenreToDB(GenreDTO genreDto) {
        GenreEntity genreEntity = genreMapper.genreDTO2Entity(genreDto);
        GenreEntity savedEntity = genreRepository.save(genreEntity);
        return genreMapper.genreEntity2DTO(savedEntity);
    }


}
