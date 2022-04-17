package com.nvkha.pokedex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvkha.pokedex.model.entity.Type;
import com.nvkha.pokedex.repository.TypeRepository;
import com.nvkha.pokedex.service.TypeService;

/**
 *
 * @author ngua
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeRepository.getById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findTypeByName(name);
    }
}
