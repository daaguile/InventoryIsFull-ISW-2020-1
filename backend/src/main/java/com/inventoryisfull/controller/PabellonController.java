package com.inventoryisfull.controller;

import com.inventoryisfull.domain.Pabellon;
import com.inventoryisfull.dto.PabellonDTO;
import com.inventoryisfull.service.PabellonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;

import com.inventoryisfull.exceptions.*;

@RestController
@CrossOrigin
@RequestMapping("/api/pabellones")
public class PabellonController {

    @Autowired
    private PabellonService pabellonService;

    // Create
    @PostMapping("")
    public ResponseEntity<PabellonDTO> addPabellon(@Validated @RequestBody Pabellon pabellon) {
        return pabellonService.savePabellon(pabellon);
    }

    // Read

    // Obtener todos los pabellones
    @GetMapping("")
    public Iterable<PabellonDTO> listPabellones() {
        return pabellonService.listPabellones();
    }

    // Obtener pabellón por id
    @GetMapping("/{id}")
    public ResponseEntity<PabellonDTO> getPabellonById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return pabellonService.getPabellonDTOById(id);
    }

    // Update

    // Editar pabellón, cambiar estado, asignar paciente, etc.
    @PutMapping("/{id}")
    public ResponseEntity<PabellonDTO> updatePabellon(@Validated @RequestBody Pabellon newPabellon, @PathVariable("id") Long id)
            throws ResourceNotFoundException {

        return pabellonService.updatePabellon(newPabellon, id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public JSONObject deletePabellon(@PathVariable("id") Long id) throws ResourceNotFoundException {

        return pabellonService.deletePabellon(id);
    }
}