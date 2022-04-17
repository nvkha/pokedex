package com.nvkha.pokedex.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvkha.pokedex.model.entity.Type;
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

    @GetMapping("/")
    public String main() {
        return "home";
    }
}
