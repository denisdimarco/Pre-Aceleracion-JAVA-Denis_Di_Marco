package com.alkemy.disneyapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieBasicDTO {

    private String image;
    private String title;
    private String creationDate;

}
