package com.nvkha.pokedex.service.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nvkha.pokedex.model.entity.Ability;
import com.nvkha.pokedex.model.entity.Type;
import com.nvkha.pokedex.repository.AbilityRepository;
import com.nvkha.pokedex.repository.TypeRepository;
import com.nvkha.pokedex.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvkha.pokedex.model.entity.Pokemon;
import com.nvkha.pokedex.repository.PokemonRepository;
import com.nvkha.pokedex.service.PokemonService;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;

/**
 *
 * @author ngua
 */
@Service
@Transactional
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TypeRepository  typeRepository;

    @Autowired
    AbilityRepository abilityRepository;

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

    @Override
    public Pokemon addPokemon(Pokemon pokemon, List<String> types, List<String> abilities) {
        List<Type> typesList = new ArrayList<>();
        List<Ability> abilityList = new ArrayList<>();
        for(String type : types) {
            typesList.add(typeRepository.findTypeByName(type));
        }

        for(String ability : abilities) {
            abilityList.add(abilityRepository.findAbilityByName(ability));
        }
        pokemon.setTypes(typesList);
        pokemon.setAbilities(abilityList);
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon deletePokemon(Long id) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        Pokemon pokemon = optionalPokemon.get();

        for(Type type : pokemon.getTypes()) {
            type.getPokemons().remove(pokemon);
        }

        for(Ability ability : pokemon.getAbilities()) {
            ability.getPokemons().remove(pokemon);
        }
        pokemonRepository.delete(pokemon);
        return pokemon;
    }

    @Override
    public Pokemon updatePokemon(Long id, Pokemon pokemon, List<String> types, List<String> abilities) {
        List<Type> typesList = new ArrayList<>();
        List<Ability> abilityList = new ArrayList<>();
        for(String type : types) {
            typesList.add(typeRepository.findTypeByName(type));
        }

        for(String ability : abilities) {
            abilityList.add(abilityRepository.findAbilityByName(ability));
        }
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
        Pokemon uPokemon = optionalPokemon.get();
        if(!abilityList.isEmpty()) {
            uPokemon.setAbilities(abilityList);
        }

        if(!typesList.isEmpty()) {
            uPokemon.setTypes(typesList);
        }

        uPokemon.setName(pokemon.getName());
        uPokemon.setHeight(pokemon.getHeight());
        uPokemon.setWeight(pokemon.getWeight());

        return uPokemon;
    }


}
