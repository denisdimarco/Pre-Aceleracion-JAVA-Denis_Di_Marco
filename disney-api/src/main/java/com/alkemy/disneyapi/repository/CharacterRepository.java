package com.alkemy.disneyapi.repository;


import com.alkemy.disneyapi.entity.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {

    List<CharacterEntity> findAll(Specification<CharacterEntity> spec);
}
