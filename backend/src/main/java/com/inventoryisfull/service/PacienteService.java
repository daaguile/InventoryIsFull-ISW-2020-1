package com.inventoryisfull.service;

import com.inventoryisfull.domain.Paciente;
import com.inventoryisfull.dto.PacienteDTO;
import com.inventoryisfull.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;

import com.inventoryisfull.exceptions.*;
import com.inventoryisfull.mapservice.PacienteMapService;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapService pacienteMapService;

    // Create
    public ResponseEntity<PacienteDTO> savePaciente(Paciente paciente) {
        Paciente newPaciente = pacienteRepository.save(paciente);
        PacienteDTO pacienteDTO = pacienteMapService.mapPacienteDTO(newPaciente);
        return ResponseEntity.ok(pacienteDTO);
    }

    // Read
    public Iterable<PacienteDTO> listPacientes() {
        return pacienteMapService.getAllPacientes();
    }

    public ResponseEntity<PacienteDTO> getPacienteDTOById(Long id) throws ResourceNotFoundException {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id: " + id));
        PacienteDTO pacienteDTO = pacienteMapService.mapPacienteDTO(paciente);
        return ResponseEntity.ok(pacienteDTO);
    }

    private ResponseEntity<Paciente> getPacienteById(Long id) throws ResourceNotFoundException {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id: " + id));
        return ResponseEntity.ok(paciente);
    }

    // Update
    public ResponseEntity<PacienteDTO> updatePaciente(Paciente editPaciente, Long id) throws ResourceNotFoundException {

        Paciente paciente = getPacienteById(id).getBody();

        paciente.setRegistro(editPaciente.getRegistro());

        return ResponseEntity.ok(pacienteMapService.mapPacienteDTO(pacienteRepository.save(paciente)));

    }


    // Delete
    public JSONObject deletePaciente(Long id) throws ResourceNotFoundException {
        Paciente paciente = getPacienteById(id).getBody();
        pacienteRepository.delete(paciente);

        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("ok", Boolean.TRUE);
        jsonObject.appendField("mensaje", "Paciente eliminado");
        return jsonObject;
    }


}