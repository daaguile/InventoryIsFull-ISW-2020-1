package com.inventoryisfull.mapservice;

import java.util.List;
import java.util.stream.Collectors;

import com.inventoryisfull.domain.Pabellon;
import com.inventoryisfull.dto.PabellonDTO;
import com.inventoryisfull.repository.PabellonRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PabellonMapService {

    @Autowired
    private PabellonRepository pabellonRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PabellonDTO mapPabellonToDTO(Pabellon pabellon) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        PabellonDTO pabellonDTO = modelMapper.map(pabellon, PabellonDTO.class);
        return pabellonDTO;
    }

    public List<PabellonDTO> getAllPabellon() {
        return ((List<Pabellon>) pabellonRepository.findAll()).stream().map(this::mapPabellonToDTO)
                .collect(Collectors.toList());
        
    }
}