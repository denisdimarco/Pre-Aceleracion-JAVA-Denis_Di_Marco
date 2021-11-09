package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.CharacterBasicDTO;
import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.entity.CharacterEntity;

import java.util.List;

public interface CharacterService {

    CharacterEntity getCharacterEntityById(Long characterId);
    CharacterDTO findCharacterDtoById(Long id);
    List<CharacterBasicDTO> getAllCharactersBasic();
    CharacterDTO  getCharacterDetailsById (Long characterId);

    CharacterDTO saveNewCharacter(CharacterDTO characterDTO);
    void deleteCharacter(Long id);
}
