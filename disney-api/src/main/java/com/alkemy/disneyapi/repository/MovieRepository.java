package com.alkemy.disneyapi.repository;

import com.alkemy.disneyapi.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findAll(Specification<MovieEntity> spec);
}
