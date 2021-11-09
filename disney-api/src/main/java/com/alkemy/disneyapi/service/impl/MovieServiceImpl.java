package com.alkemy.disneyapi.service.impl;

import com.alkemy.disneyapi.dto.MovieBasicDTO;
import com.alkemy.disneyapi.dto.MovieDTO;
import com.alkemy.disneyapi.dto.MovieFiltersDTO;
import com.alkemy.disneyapi.entity.CharacterEntity;
import com.alkemy.disneyapi.entity.MovieEntity;
import com.alkemy.disneyapi.exception.ParamNotFound;
import com.alkemy.disneyapi.mapper.CharacterMapper;
import com.alkemy.disneyapi.mapper.MovieMapper;
import com.alkemy.disneyapi.repository.MovieRepository;
import com.alkemy.disneyapi.repository.specifications.MovieSpecifications;
import com.alkemy.disneyapi.service.CharacterService;
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
    @Autowired
    private CharacterService characterService;
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private MovieSpecifications movieSpecifications;

    //GET
    public List<MovieBasicDTO> getAllMoviesLite() {
        List<MovieEntity> entitiesList = movieRepository.findAll();
        return movieMapper.movieEntityList2BasicDTOList(entitiesList);
    }

    public MovieDTO getMovieDetailsById(Long id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        if (!movieEntity.isPresent()) {
            throw new ParamNotFound("Movie ID not valid.");
        }
        return movieMapper.movieEntity2DTO(movieEntity.get(), true);
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

    //DELETE
    public void deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new ParamNotFound("Movie ID not exists in Database");
        }
    }

    public void deleteCharacterFromMovie(Long movieId, Long characterId) {
        MovieEntity movie = getMovieEntityById(movieId);
        movie.getCharacters().size();
        CharacterEntity characterEntity = characterService.getCharacterEntityById(characterId);
        movie.removeCharacterFromMovie(characterEntity);
        movieRepository.save(movie);

    }

    //Filters
    public List<MovieDTO> getMoviesByFilters(String title, String genre, String order) {
        MovieFiltersDTO movieFiltersDto = new MovieFiltersDTO(title, genre, order);
        List<MovieEntity> movieEntities = movieRepository.findAll(movieSpecifications.getByFilters(movieFiltersDto));
        return movieMapper.movieEntityList2DTOList(movieEntities, true);
    }

    // Aditional Methods
    public MovieEntity getMovieEntityById(Long movieId) {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (!movie.isPresent()) {
            throw new ParamNotFound("Movie Id not found");
        }
        return movie.get();
    }

    public void addCharacterToMovie(Long movieId, Long characterId) {
        MovieEntity movie = this.getMovieEntityById(movieId);
        movie.getCharacters().size();
        CharacterEntity characterEntity = characterService.getCharacterEntityById(characterId);
        movie.addCharacterToMovie(characterEntity);
        movieRepository.save(movie);
    }

}
