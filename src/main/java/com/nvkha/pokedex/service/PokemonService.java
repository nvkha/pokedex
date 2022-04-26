package com.nvkha.pokedex.service;

import java.util.List;

import com.nvkha.pokedex.model.entity.Pokemon;

/**
 *
 * @author ngua
 */
public interface PokemonService {
    void save(Pokemon pokemon);

    List<Pokemon>  getAllPokemon();

    Pokemon getPokemonById(Long id);

    Pokemon addPokemon(Pokemon pokemon, List<String> types, List<String> abilities);

    Pokemon deletePokemon(Long id);

    Pokemon updatePokemon(Long id, Pokemon pokemon, List<String> types, List<String> abilities);
}
