package com.inventoryisfull.mapservice;

import java.util.List;
import java.util.stream.Collectors;

import com.inventoryisfull.domain.Paciente;
import com.inventoryisfull.dto.PacienteDTO;
import com.inventoryisfull.repository.PacienteRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteMapService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PacienteDTO mapPacienteDTO(Paciente paciente) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        PacienteDTO pacienteDTO = modelMapper.map(paciente, PacienteDTO.class);

        return pacienteDTO;
    }
    
    public List<PacienteDTO> getAllPacientes() {
        return ((List<Paciente>) pacienteRepository.findAll()).stream().map(this::mapPacienteDTO)
                .collect(Collectors.toList());
    }
}