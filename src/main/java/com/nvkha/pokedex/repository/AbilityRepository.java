package com.nvkha.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nvkha.pokedex.model.entity.Ability;

/**
 *
 * @author ngua
 */
@Repository
public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Ability findAbilityByName(String name);
}
