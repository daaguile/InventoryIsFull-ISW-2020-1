package com.inventoryisfull.service;

import java.util.Map;
import java.util.HashMap;
import com.inventoryisfull.domain.Paciente;
import com.inventoryisfull.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.inventoryisfull.exceptions.*;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Create
    public ResponseEntity<Paciente> savePaciente(Paciente paciente) {
        Paciente newPaciente = pacienteRepository.save(paciente);
        return ResponseEntity.ok(newPaciente);
    }

    // Read
    public Iterable<Paciente> listPacientes() {
        return pacienteRepository.findAll();
    }

    public ResponseEntity<Paciente> getPacienteById(Long id) throws ResourceNotFoundException {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente not found for this id: " + id));
        return ResponseEntity.ok(paciente);
    }

    // Update
    public ResponseEntity<Paciente> updatePaciente(Paciente editPaciente, Long id) throws ResourceNotFoundException {

        Paciente paciente = getPacienteById(id).getBody();

        paciente.setNombres(editPaciente.getNombres());
        paciente.setApellidoPaterno(editPaciente.getApellidoPaterno());
        paciente.setApellidoMaterno(editPaciente.getApellidoMaterno());
        paciente.setRut(editPaciente.getRut());
        paciente.setDao(editPaciente.getDao());

        final Paciente updatedPaciente = savePaciente(paciente).getBody();
        return ResponseEntity.ok(updatedPaciente);

    }


    // Delete
    public Map<String, Boolean> deletePaciente(Long id) throws ResourceNotFoundException {
        Paciente paciente = getPacienteById(id).getBody();
        pacienteRepository.delete(paciente);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}