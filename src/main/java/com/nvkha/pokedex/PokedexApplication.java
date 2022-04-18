package com.nvkha.pokedex;

import java.net.MalformedURLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nvkha.pokedex.model.entity.Ability;
import com.nvkha.pokedex.model.entity.Pokemon;
import com.nvkha.pokedex.model.entity.Type;
import com.nvkha.pokedex.service.AbilityService;
import com.nvkha.pokedex.service.PokemonService;
import com.nvkha.pokedex.service.TypeService;
import com.nvkha.pokedex.util.PokeAPICaller;

@SpringBootApplication
public class PokedexApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokedexApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TypeService typeService, AbilityService abilityService, PokemonService pokemonService) {
        return args -> {
            /*
            PokeAPICaller pokeAPICaller = new PokeAPICaller(typeService, abilityService);
            for (Type type : pokeAPICaller.getAllType()) {
                typeService.save(type);
            }
            for(Ability ability : pokeAPICaller.getAllAbility()) {
                abilityService.save(ability);
            }
            for(Pokemon pokemon : pokeAPICaller.getListPokemon()) {
                pokemonService.save(pokemon);
            }
            */
        };
    }
}
