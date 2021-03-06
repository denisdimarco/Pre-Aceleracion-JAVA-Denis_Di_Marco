package com.alkemy.disneyapi.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterBasicDTO {
    private String image;
    private String name;
}
