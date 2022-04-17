package com.nvkha.pokedex.service;

import com.nvkha.pokedex.model.entity.Type;

/**
 *
 * @author ngua
 */
public interface TypeService {
    void save(Type type);

    Type getTypeById(Long id);

    Type getTypeByName(String name);
}
