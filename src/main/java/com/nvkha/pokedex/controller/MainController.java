package com.nvkha.pokedex.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvkha.pokedex.model.entity.Type;
import com.nvkha.pokedex.service.PokemonService;
import com.nvkha.pokedex.service.TypeService;
import com.nvkha.pokedex.util.PokeAPICaller;

/**
 *
 * @author ngua
 */
@Controller
public class MainController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("pokemons", pokemonService.getAllPokemon());
        return "home";
    }
}
