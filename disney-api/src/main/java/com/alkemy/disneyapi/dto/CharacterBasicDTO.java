package com.alkemy.disneyapi.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterBasicDTO {

    //TODO: ID not requested in instructions.
    //private Long id;
    private String image;
    private String name;

}
