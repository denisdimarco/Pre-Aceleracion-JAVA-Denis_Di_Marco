package com.alkemy.disneyapi.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterBasicDTO {

    private String image;
    private String name;

}
