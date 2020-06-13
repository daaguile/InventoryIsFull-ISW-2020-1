package com.inventoryisfull.controller;

import com.inventoryisfull.repository.PersonalRepository;
import com.inventoryisfull.domain.Personal;
import com.inventoryisfull.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;


@RestController
public class PersonalController {

    @Autowired
    private PersonalRepository personalRepository;

    @GetMapping("/api/personal")
    public List<Personal> getAllPersonal(){
        return personalRepository.findAll();
    }
    
    @GetMapping("/api/personal/{id}")
    public ResponseEntity<Personal> getpersonalById(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
        Personal personal = personalRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("personal not found for this id :: " + id));
        return ResponseEntity.ok().body(personal);
    }

    @PostMapping("/api/personal")
    public Personal createPersonal(@Validated @RequestBody Personal personal){
        return personalRepository.save(personal);
    }

    @PutMapping("/api/personal/{id}")
    public ResponseEntity<Personal> updatePersonal(@PathVariable(value="id") Long id, @Validated @RequestBody Personal personalDetails) throws ResourceNotFoundException {
        Personal personal = personalRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("personal not found for this id :: " + id));

        personal.setNombre(personalDetails.getNombre());
        personal.setOcupacion(personalDetails.getOcupacion());
        personal.setArea(personalDetails.getArea());
        final Personal updatedpersonal = personalRepository.save(personal);
        return ResponseEntity.ok(updatedpersonal);
        
    }

    @DeleteMapping("/api/personal/{id}")
    public Map<String, Boolean> deletePersonal(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
        Personal personal = personalRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("personal not found for this id :: " + id));

        personalRepository.delete(personal);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}