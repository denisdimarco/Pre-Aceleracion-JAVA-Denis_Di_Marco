package com.alkemy.disneyapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterDTO {

    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Double weight;
    private String history;

    //TODO: Check if is MovieBasicDTO or MovieDTO
    private List<MovieDTO> movies;
}
