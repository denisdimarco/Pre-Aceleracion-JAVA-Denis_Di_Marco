package com.alkemy.disneyapi.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

    private Long id;
    private String image;
    private String title;
    private String creationDate;
    private Integer rating;
    private Long genreId;

    //TODO Check if GenreDTO genre its ok or its only the name field of the genre (and how to put that).
    private GenreDTO genre;

    private List<CharacterDTO> charactersList;

}
