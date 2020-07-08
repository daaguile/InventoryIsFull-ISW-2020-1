package com.inventoryisfull.controller;

import java.util.Map;
import com.inventoryisfull.domain.Personal;
import com.inventoryisfull.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.inventoryisfull.exceptions.*;

@RestController
@CrossOrigin
@RequestMapping("/api/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    // Create
    @PostMapping("")
    public ResponseEntity<Personal> addPersonal(@Validated @RequestBody Personal personal) {
        return personalService.savePersonal(personal);
    }

    // Read
    @GetMapping("")
    public Iterable<Personal> getPersonals() {
        return personalService.listPersonals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return personalService.getPersonalById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Personal> updatePersonal(@Validated @RequestBody Personal newPersonal,
            @PathVariable("id") Long id) throws ResourceNotFoundException {

        return personalService.updatePersonal(newPersonal, id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePersonal(@PathVariable("id") Long id) throws ResourceNotFoundException {

        return personalService.deletePersonal(id);
    }

}