package com.nvkha.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nvkha.pokedex.model.entity.Type;

/**
 *
 * @author ngua
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findTypeByName(String name);
}
