package com.alkemy.disneyapi.service.impl;

import com.alkemy.disneyapi.exception.ParamNotFound;
import com.alkemy.disneyapi.mapper.GenreMapper;
import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.entity.GenreEntity;
import com.alkemy.disneyapi.repository.GenreRepository;
import com.alkemy.disneyapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreMapper genreMapper;

    public List<GenreDTO> getAllGenres() {
        List<GenreEntity> genreEntities = genreRepository.findAll();
        return genreMapper.genreEntityList2DTOList(genreEntities);
    }

    @Override
    public GenreDTO getGenreById(Long genreId) {
        Optional<GenreEntity> genreEntity = this.genreRepository.findById(genreId);
        if (!genreEntity.isPresent()) {
            throw new ParamNotFound("Genre ID not valid");
        }
        return genreMapper.genreEntity2DTO(genreEntity.get());
    }

    public GenreDTO saveGenreToDB(GenreDTO genreDto) {
        GenreEntity genreEntity = genreMapper.genreDTO2Entity(genreDto);
        GenreEntity savedEntity = genreRepository.save(genreEntity);
        return genreMapper.genreEntity2DTO(savedEntity);
    }


    public GenreDTO updateGenreInDB(Long id, GenreDTO genreNewData) {
        Optional<GenreEntity> entity = genreRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Genre Id not valid");
        }
        genreMapper.genreEntityRefreshValues(entity.get(), genreNewData);
        GenreEntity entitySaved = genreRepository.save(entity.get());
        return genreMapper.genreEntity2DTO(entitySaved);

    }


}
