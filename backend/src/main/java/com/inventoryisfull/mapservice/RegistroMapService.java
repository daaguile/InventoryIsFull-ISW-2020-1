package com.inventoryisfull.mapservice;

import java.util.List;
import java.util.stream.Collectors;

import com.inventoryisfull.domain.Registro;
import com.inventoryisfull.dto.RegistroDTO;
import com.inventoryisfull.repository.RegistroRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroMapService {

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private ModelMapper modelMapper;


    public RegistroDTO mapRegistroToDTO(Registro registro) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        RegistroDTO registroDTO = modelMapper.map(registro, RegistroDTO.class);
        return registroDTO;
    }

    public List<RegistroDTO> getAllRegistros() {
        return ((List<Registro>) registroRepository.findAll()).stream().map(this::mapRegistroToDTO)
                .collect(Collectors.toList());
    }
    
}