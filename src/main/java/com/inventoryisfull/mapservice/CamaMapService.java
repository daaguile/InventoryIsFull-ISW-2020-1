package com.inventoryisfull.mapservice;

import java.util.List;
import java.util.stream.Collectors;

import com.inventoryisfull.domain.Cama;
import com.inventoryisfull.dto.CamaDTO;
import com.inventoryisfull.repository.CamaRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamaMapService {
    
    @Autowired
    private CamaRepository camaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CamaDTO mapCamaToDTO(Cama cama) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CamaDTO camaDTO = modelMapper.map(cama, CamaDTO.class);
        return camaDTO;
    }

    public List<CamaDTO> getAllCamas() {
        return ((List<Cama>) camaRepository.findAll()).stream().map(this::mapCamaToDTO).collect(Collectors.toList());
    }
}