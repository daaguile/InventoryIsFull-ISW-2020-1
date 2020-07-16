package com.inventoryisfull.controller;

import com.inventoryisfull.domain.Paciente;
import com.inventoryisfull.dto.PacienteDTO;
import com.inventoryisfull.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;

import com.inventoryisfull.exceptions.*;

@RestController
@CrossOrigin
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Create
    @PostMapping("")
    public ResponseEntity<PacienteDTO> addPaciente(@Validated @RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    // Read
    @GetMapping("")
    public Iterable<PacienteDTO> getPacientes() {
        return pacienteService.listPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return pacienteService.getPacienteDTOById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@Validated @RequestBody Paciente editPaciente, @PathVariable("id") Long id)
            throws ResourceNotFoundException {

        return pacienteService.updatePaciente(editPaciente, id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public JSONObject deletePaciente(@PathVariable("id") Long id) throws ResourceNotFoundException {

        return pacienteService.deletePaciente(id);
    }

}