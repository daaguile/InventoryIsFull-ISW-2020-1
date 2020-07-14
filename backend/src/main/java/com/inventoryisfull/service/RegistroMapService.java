package com.inventoryisfull.service;

import com.inventoryisfull.domain.Registro;
import com.inventoryisfull.dto.RegistroDTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroMapService {

    @Autowired
    private ModelMapper modelMapper;


    public RegistroDTO mapRegistroToDTO(Registro registro) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        RegistroDTO registroDTO = modelMapper.map(registro, RegistroDTO.class);
        return registroDTO;
    }
    
}