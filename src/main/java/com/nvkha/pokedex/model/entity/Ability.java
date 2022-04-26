package com.nvkha.pokedex.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ability {
    @Id
    private Long id;
    private String name;
    @Column(columnDefinition ="TEXT")
    private String effect;

    @ManyToMany(mappedBy = "abilities", fetch = FetchType.EAGER)
    private Set<Pokemon> pokemons = new HashSet<>();

    public Ability() {}

    public Ability(Long id, String name, String effect) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }

    public Ability(String name, Set<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public Long getId() {
        return id;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
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

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }
}
