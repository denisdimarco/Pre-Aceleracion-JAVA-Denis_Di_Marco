package com.alkemy.disneyapi.service.impl;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.entity.MovieEntity;
import com.alkemy.disneyapi.exception.ParamNotFound;
import com.alkemy.disneyapi.mapper.MovieMapper;
import com.alkemy.disneyapi.repository.MovieRepository;
import com.alkemy.disneyapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    //GET
    public List<MovieBasicDTO> getAllMoviesLite() {
        List<MovieEntity> entitiesList = movieRepository.findAll();
        return movieMapper.movieEntityList2BasicDTOList(entitiesList);
    }

    //SAVE
    public MovieDTO saveNewMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = movieMapper.movieDTO2Entity(movieDTO);
        MovieEntity entitySaved = movieRepository.save(movieEntity);
        return movieMapper.movieEntity2DTO(entitySaved, true);
    }

    //UPDATE
    public MovieDTO updateMovieById(Long id, MovieDTO movieNewData) {

        Optional<MovieEntity> entity = this.movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Movie ID not valid.");
        }
        this.movieMapper.movieEntityRefreshValues(entity.get(), movieNewData);
        MovieEntity entitySaved = this.movieRepository.save(entity.get());
        return this.movieMapper.movieEntity2DTO(entitySaved, false);

    }


}
