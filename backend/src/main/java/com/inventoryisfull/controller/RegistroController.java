package com.inventoryisfull.controller;

import com.inventoryisfull.domain.Registro;
import com.inventoryisfull.dto.RegistroDTO;
import com.inventoryisfull.exceptions.ResourceNotFoundException;
import com.inventoryisfull.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/pacientes/pabellon")
@JsonComponent
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    // Create
    //@PostMapping(value = "/pabellon", consumes = "application/json", produces = "application/json")
    @PostMapping("")
    public ResponseEntity<RegistroDTO> createRegistro(@Validated @RequestBody Registro registro)
            throws ResourceNotFoundException {
        return registroService.saveRegistro(registro);
    }
    
}