package com.nvkha.pokedex.controller;

import com.nvkha.pokedex.model.dto.PokemonDto;
import com.nvkha.pokedex.model.entity.Ability;
import com.nvkha.pokedex.model.entity.Pokemon;
import com.nvkha.pokedex.model.entity.Type;
import com.nvkha.pokedex.service.PokemonService;
import com.nvkha.pokedex.util.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/api/v1/pokemon")
    public PokemonDto addPokemon(@RequestBody Pokemon pokemon, @RequestParam List<String> types, @RequestParam List<String> abilities) {
        Pokemon newPokemon = pokemonService.addPokemon(pokemon, types, abilities);
        if(pokemon == null) {
            throw new IllegalArgumentException("Invalid request! pokemon is null");
        }
        return ApplicationMapper.pokemonToPokemonDto(newPokemon);
    }

    @DeleteMapping("/api/v1/pokemon/{id}")
    public PokemonDto deletePokemon(@PathVariable Long id) {
        if(id == null) {
            throw new IllegalArgumentException("Invalid request! id is null");
        }
        return ApplicationMapper.pokemonToPokemonDto(pokemonService.deletePokemon(id));
    }

    @PutMapping("/api/v1/pokemon/{id}")
    public PokemonDto updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon, @RequestParam List<String> types, @RequestParam List<String> abilities) {
        if(id == null) {
            throw new IllegalArgumentException("Invalid request! id is null");
        }
        return ApplicationMapper.pokemonToPokemonDto(pokemonService.updatePokemon(id, pokemon, types, abilities));
    }
}
