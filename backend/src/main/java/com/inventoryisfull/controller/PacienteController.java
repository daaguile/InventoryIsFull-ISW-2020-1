package com.inventoryisfull.controller;

import java.util.Map;
import com.inventoryisfull.domain.Paciente;
import com.inventoryisfull.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.inventoryisfull.exceptions.*;

@RestController
@CrossOrigin
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Create
    @PostMapping("")
    public ResponseEntity<Paciente> addPaciente(@Validated @RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    // Read
    @GetMapping("")
    public Iterable<Paciente> getPacientes() {
        return pacienteService.listPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return pacienteService.getPacienteById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@Validated @RequestBody Paciente editPaciente, @PathVariable("id") Long id)
            throws ResourceNotFoundException {

        return pacienteService.updatePaciente(editPaciente, id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePaciente(@PathVariable("id") Long id) throws ResourceNotFoundException {

        return pacienteService.deletePaciente(id);
    }

}