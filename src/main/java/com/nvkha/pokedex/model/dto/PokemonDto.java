package com.nvkha.pokedex.model.dto;

import com.nvkha.pokedex.model.entity.Ability;
import com.nvkha.pokedex.model.entity.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class PokemonDto {
    private Long id;
    private String name;
    private Double weight;
    private Double height;

    private List<Type> types;

    private List<Ability> abilities;

    public PokemonDto() {}

    public PokemonDto(Long id, String name, Double weight, Double height) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public PokemonDto(String name, Double weight, Double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
