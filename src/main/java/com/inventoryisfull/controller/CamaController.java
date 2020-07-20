package com.inventoryisfull.controller;

import com.inventoryisfull.domain.Cama;
import com.inventoryisfull.dto.CamaDTO;
import com.inventoryisfull.exceptions.ResourceNotFoundException;
import com.inventoryisfull.service.CamaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/api/recuperacion/camas")
public class CamaController {

    @Autowired
    private CamaService camaService;

    // Create
    @PostMapping("")
    public ResponseEntity<CamaDTO> addCama(@Validated @RequestBody Cama cama) {
        return camaService.saveCama(cama);
    }

    // Read

    // Obtener todas las camas
    @GetMapping("")
    public Iterable<CamaDTO> listCamas() {
        return camaService.listCamas();
    }

    // Obtener cama por id
    @GetMapping("/{id}")
    public ResponseEntity<CamaDTO> getCamaById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return camaService.getCamaDTOById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CamaDTO> updateCama(@Validated @RequestBody JSONObject editCama, @PathVariable("id") Long id)
            throws ResourceNotFoundException {
        return camaService.updateCama(editCama, id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public JSONObject deleteCama(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return camaService.deleteCama(id);
    }

}