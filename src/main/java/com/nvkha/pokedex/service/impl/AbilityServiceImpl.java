package com.nvkha.pokedex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvkha.pokedex.model.entity.Ability;
import com.nvkha.pokedex.repository.AbilityRepository;
import com.nvkha.pokedex.service.AbilityService;

/**
 *
 * @author ngua
 */
@Service
public class AbilityServiceImpl implements AbilityService {
    @Autowired
    private AbilityRepository abilityRepository;

    @Override
    public void save(Ability ability) {
        abilityRepository.save(ability);
    }

    @Override
    public Ability getAbilityByName(String name) {
        return abilityRepository.findAbilityByName(name);
    }
}
