package com.alkemy.disneyapi.service;

import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.entity.CharacterEntity;

public interface CharacterService {

    CharacterEntity getCharacterEntityById(Long characterId);
    CharacterDTO findCharacterDtoById(Long id);
}
