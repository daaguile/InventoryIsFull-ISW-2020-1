package com.inventoryisfull.controller;

import java.util.Map;
import com.inventoryisfull.domain.Pabellon;
import com.inventoryisfull.service.PabellonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.inventoryisfull.exceptions.*;

@RestController
@CrossOrigin
@RequestMapping("/api/pabellones")
public class PabellonController {

    @Autowired
    private PabellonService pabellonService;

    // Create
    @PostMapping("")
    public ResponseEntity<Pabellon> addPabellon(@Validated @RequestBody Pabellon pabellon) {
        return pabellonService.savePabellon(pabellon);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<Pabellon> getPabellonById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return pabellonService.getPabellonById(id);
    }

    @GetMapping("")
    public Iterable<Pabellon> listPabellones() {
        return pabellonService.listPabellones();
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Pabellon> updatePabellon(@Validated @RequestBody Pabellon newPabellon, @PathVariable("id") Long id)
            throws ResourceNotFoundException {

        return pabellonService.updatePabellon(newPabellon, id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePabellon(@PathVariable("id") Long id) throws ResourceNotFoundException {

        return pabellonService.deletePabellon(id);
    }
}