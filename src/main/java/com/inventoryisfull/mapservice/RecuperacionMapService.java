package com.inventoryisfull.mapservice;

import java.util.List;
import java.util.stream.Collectors;

import com.inventoryisfull.domain.Recuperacion;
import com.inventoryisfull.dto.RecuperacionDTO;
import com.inventoryisfull.repository.RecuperacionRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecuperacionMapService {
    
    @Autowired
    private RecuperacionRepository recuperacionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RecuperacionDTO mapRecuperacionToDTO(Recuperacion recuperacion) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        RecuperacionDTO recuperacionDTO = modelMapper.map(recuperacion, RecuperacionDTO.class);
        return recuperacionDTO;
    }

    public List<RecuperacionDTO> getAllRecuperacion() {
        return ((List<Recuperacion>) recuperacionRepository.findAll()).stream()
                .map(this::mapRecuperacionToDTO)
                .collect(Collectors.toList());
    }
}