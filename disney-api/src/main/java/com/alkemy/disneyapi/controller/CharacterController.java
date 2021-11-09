package com.alkemy.disneyapi.controller;

import com.alkemy.disneyapi.dto.CharacterBasicDTO;
import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    //TODO 3. Basic Character List
    //GET /characters (It must show only image and name fields)
    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getAllCharactersLite() {
        List<CharacterBasicDTO> charactersBasicList = characterService.getAllCharactersBasic();
        return ResponseEntity.ok(charactersBasicList);
    }
    //TODO 4. CRUD
    //TODO POST /characters
    //TODO POST /characters/{

    //TODO 5. Full Character Details with associated movies.
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharactersDetailsById(@PathVariable Long id) {
        CharacterDTO characterDto = characterService.getCharacterDetailsById(id);
        return ResponseEntity.ok(characterDto);
    }

    //TODO 6. Search Characters by filters

    // GET /characters?name=name
    // GET /characters?age=age
    // GET /characters?movies=movieId


}
