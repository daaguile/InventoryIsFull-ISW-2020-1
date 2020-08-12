package com.inventoryisfull.controller;

import com.inventoryisfull.domain.Recuperacion;
import com.inventoryisfull.dto.RecuperacionDTO;
import com.inventoryisfull.exceptions.ResourceNotFoundException;
import com.inventoryisfull.service.RecuperacionService;

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
@RequestMapping("/api/recuperacion")
public class RecuperacionController {

    @Autowired
    private RecuperacionService recuperacionService;

    // Create
    @PostMapping("")
    public ResponseEntity<RecuperacionDTO> addRecuperacion(@Validated @RequestBody Recuperacion recuperacion) {
        return recuperacionService.saveRecuperacion(recuperacion);
    }

    // Read

    // Obtener todas las salas
    @GetMapping("")
    public Iterable<RecuperacionDTO> listRecuperacion() {
        return recuperacionService.listRecuperacion();
    }

    // Obterner sala por id
    @GetMapping("/{id}")
    public ResponseEntity<RecuperacionDTO> getRecuperacionById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        return recuperacionService.getRecuperacionDTOById(id);
    }

    // Asignar cama a sala
    @PostMapping("/cama")
    public ResponseEntity<RecuperacionDTO> camaToRecuperacion(@RequestBody JSONObject camaRecuperacion)
            throws ResourceNotFoundException {

        return recuperacionService.camaToRecuperacion(camaRecuperacion);

    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<RecuperacionDTO> updateRecuperacion(@Validated @RequestBody Recuperacion editRecuperacion,
            @PathVariable("id") Long id) throws ResourceNotFoundException {

        return recuperacionService.updateRecuperacion(editRecuperacion, id);
    }

    // Eliminar cama de sala
    @DeleteMapping("/camas")
    public ResponseEntity<RecuperacionDTO> camaOutRecuperacion(@RequestBody JSONObject camaRecuperacion)
            throws ResourceNotFoundException {
        return recuperacionService.camaOutRecuperacion(camaRecuperacion);

    }

    // Delete Sala
    @DeleteMapping("/{id}")
    public JSONObject deleteRecuperacion(@PathVariable("id") Long id) throws ResourceNotFoundException {

        return recuperacionService.deleteRecuperacion(id);
    }

}