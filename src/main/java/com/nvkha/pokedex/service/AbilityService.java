package com.nvkha.pokedex.service;

import com.nvkha.pokedex.model.entity.Ability;

/**
 *
 * @author ngua
 */
public interface AbilityService {
    void save(Ability ability);

    Ability getAbilityByName(String name);
}
