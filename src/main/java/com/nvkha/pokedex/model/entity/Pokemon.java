package com.nvkha.pokedex.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Pokemon {
    @Id
    private Long id;
    private String name;
    private Double weight;
    private Double height;

    @ManyToMany
    @JsonIgnore
    private List<Type> types = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<Ability> abilities = new ArrayList<>();

    public Pokemon() {}

    public Pokemon(Long id, String name, Double weight, Double height) {
        this.id = id;
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
