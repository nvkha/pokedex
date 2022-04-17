package com.nvkha.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nvkha.pokedex.model.entity.Pokemon;

/**
 *
 * @author ngua
 */
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
