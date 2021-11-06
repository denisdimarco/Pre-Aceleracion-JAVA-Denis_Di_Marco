package com.alkemy.disneyapi.repository;


import com.alkemy.disneyapi.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {

    //List<CharacterEntity> findAll(Specification<CharacterEntity> spec);
}
