package com.nvkha.pokedex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvkha.pokedex.model.entity.Pokemon;
import com.nvkha.pokedex.repository.PokemonRepository;
import com.nvkha.pokedex.service.PokemonService;

/**
 *
 * @author ngua
 */
@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

    @Override
    public void save(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.getById(id);
    }
}
