package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.CharacterBasicDTO;
import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.entity.CharacterEntity;

import java.util.List;
import java.util.Set;

public interface CharacterService {

    CharacterEntity getCharacterEntityById(Long characterId);
    CharacterDTO findCharacterDtoById(Long id);
    List<CharacterBasicDTO> getAllCharactersBasic();
    CharacterDTO  getCharacterDetailsById (Long characterId);

    CharacterDTO saveNewCharacter(CharacterDTO characterDTO);
    void deleteCharacter(Long id);

    CharacterDTO updateCharacter(Long id, CharacterDTO character);

    List<CharacterDTO> getCharactersByFilters(String name, Integer age, Set<Long> movies);
}
