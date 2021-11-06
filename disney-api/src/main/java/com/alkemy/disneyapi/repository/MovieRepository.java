package com.alkemy.disneyapi.repository;

import com.alkemy.disneyapi.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    //List<MovieEntity> findAll(Specification<MovieEntity> spec);
}
