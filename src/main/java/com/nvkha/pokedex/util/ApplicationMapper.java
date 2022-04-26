package com.nvkha.pokedex.util;

import com.nvkha.pokedex.model.dto.PokemonDto;
import com.nvkha.pokedex.model.entity.Pokemon;
import org.springframework.stereotype.Component;


public class ApplicationMapper {
    public static PokemonDto pokemonToPokemonDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setHeight(pokemon.getHeight());
        pokemonDto.setWeight(pokemon.getWeight());
        pokemonDto.setTypes(pokemon.getTypes());
        pokemonDto.setAbilities(pokemon.getAbilities());
        return pokemonDto;
    }
}
