package com.alkemy.disneyapi.mapper;


import com.alkemy.disneyapi.dto.GenreDTO;
import com.alkemy.disneyapi.dto.MovieBasicDTO;

import com.alkemy.disneyapi.entity.GenreEntity;
import com.alkemy.disneyapi.entity.MovieEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MovieMapper {


    /* Entity to BasicDTO */
    public MovieBasicDTO movieEntity2BasicDTO(MovieEntity entity) {
        MovieBasicDTO dto = new MovieBasicDTO();
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate().toString());
        return dto;
    }

    /* List<Entity> to List<BasicDTO> */
    public List<MovieBasicDTO> movieEntityList2BasicList(List<MovieEntity> entityList) {
        List<MovieBasicDTO> basicDTOList = new ArrayList<>();
        for (MovieEntity entity : entityList) {
            basicDTOList.add(movieEntity2BasicDTO(entity));
        }
        return basicDTOList;
    }


    private LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate, formatter);
    }
}
