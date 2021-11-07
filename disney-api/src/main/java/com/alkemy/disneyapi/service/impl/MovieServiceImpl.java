package com.alkemy.disneyapi.service.impl;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.entity.MovieEntity;
import com.alkemy.disneyapi.mapper.MovieMapper;
import com.alkemy.disneyapi.repository.MovieRepository;
import com.alkemy.disneyapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    public List<MovieBasicDTO> getAllMoviesLite() {
        List<MovieEntity> entitiesList = movieRepository.findAll();
        return movieMapper.movieEntityList2BasicList(entitiesList);
    }


}
