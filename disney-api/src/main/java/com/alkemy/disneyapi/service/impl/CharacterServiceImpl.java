package com.alkemy.disneyapi.service.impl;

import com.alkemy.disneyapi.dto.CharacterBasicDTO;
import com.alkemy.disneyapi.dto.CharacterDTO;
import com.alkemy.disneyapi.dto.CharacterFiltersDTO;
import com.alkemy.disneyapi.entity.CharacterEntity;

import com.alkemy.disneyapi.exception.ParamNotFound;
import com.alkemy.disneyapi.mapper.CharacterMapper;
import com.alkemy.disneyapi.repository.CharacterRepository;
import com.alkemy.disneyapi.repository.specifications.CharacterSpecification;
import com.alkemy.disneyapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterSpecification characterSpecification;


    public CharacterEntity getCharacterEntityById(Long characterId) {
        Optional<CharacterEntity> character = characterRepository.findById(characterId);
        if (!character.isPresent()) {
            throw new ParamNotFound("Character Id not valid");
        }
        return character.get();
    }

    public List<CharacterBasicDTO> getAllCharactersBasic() {
        List<CharacterEntity> characterEntitiesBasicList = characterRepository.findAll();
        return characterMapper.characterEntityList2BasicDTOList(characterEntitiesBasicList);
    }

    public CharacterDTO getCharacterDetailsById(Long characterId) {
        Optional<CharacterEntity> character = characterRepository.findById(characterId);
        if (!character.isPresent()) {
            throw new ParamNotFound("Character Id not found");
        }
        return characterMapper.characterEntity2DTO(character.get(), true);
    }

    public CharacterDTO saveNewCharacter(CharacterDTO characterDTO) {
        CharacterEntity entity = characterMapper.characterDTO2Entity(characterDTO);
        CharacterEntity entitySaved = characterRepository.save(entity);
        return characterMapper.characterEntity2DTO(entitySaved, false);

    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    public CharacterDTO updateCharacter(Long id, CharacterDTO characterNewData){
        Optional<CharacterEntity> entity = this.characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Character ID not valid");
        }
        characterMapper.characterEntityRefreshValues(entity.get(), characterNewData);
        CharacterEntity entitySaved = characterRepository.save(entity.get());
        return characterMapper.characterEntity2DTO(entitySaved, false);
    }

    public List<CharacterDTO> getCharactersByFilters(String name, Integer age, Set<Long> movies) {
        CharacterFiltersDTO characterFiltersDto = new CharacterFiltersDTO(name, age, movies);
        List<CharacterEntity> entitiesList = characterRepository.findAll(characterSpecification.getByFilters(characterFiltersDto));
        return characterMapper.characterEntityList2DTOList(entitiesList, true);
    }
}
