package com.alkemy.disneyapi.controller;

import com.alkemy.disneyapi.dto.CharacterBasicDTO;
import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    //3. Basic Character List
    //GET /characters (It must show only image and name fields)
    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getAllCharactersLite() {
        List<CharacterBasicDTO> charactersBasicList = characterService.getAllCharactersBasic();
        return ResponseEntity.ok(charactersBasicList);
    }

    //4. CRUD
    //POST /characters
    @PostMapping
    public ResponseEntity<CharacterDTO> postNewCharacter(@RequestBody CharacterDTO characterDto) {
        CharacterDTO savedCharacter = characterService.saveNewCharacter(characterDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    //TODO PUT /characters/{id}

    //DELETE /characters/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacterById(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //TODO 5. Full Character details with associated movies.
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharactersDetailsById(@PathVariable Long id) {
        CharacterDTO characterDto = characterService.getCharacterDetailsById(id);
        return ResponseEntity.ok(characterDto);
    }

    //TODO 6. Search Characters by filters
    //TODO GET /filters
    // GET /characters?name=name
    // GET /characters?age=age
    // GET /characters?movies=movieId


}
