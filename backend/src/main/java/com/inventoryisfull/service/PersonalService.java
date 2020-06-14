package com.inventoryisfull.service;

import java.util.Map;
import java.util.HashMap;
import com.inventoryisfull.domain.Personal;
import com.inventoryisfull.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.inventoryisfull.exceptions.*;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    // Create
    public ResponseEntity<Personal> savePersonal(Personal personal) {
        Personal newPersonal = personalRepository.save(personal);
        return ResponseEntity.ok(newPersonal);
    }

    // Read
    public Iterable<Personal> listPersonals() {
        return personalRepository.findAll();
    }

    public ResponseEntity<Personal> getPersonalById(Long id) throws ResourceNotFoundException {
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personal not found for this id: " + id));
        return ResponseEntity.ok(personal);
    }

    // Update
    public ResponseEntity<Personal> updatePersonal(Personal editPersonal, Long id) throws ResourceNotFoundException {

        Personal personal = getPersonalById(id).getBody();

        personal.setArea(editPersonal.getArea());
        personal.setNombre(editPersonal.getNombre());
        personal.setOcupacion(editPersonal.getOcupacion());
        personal.setRut(editPersonal.getRut());
        personal.setRol(editPersonal.getRol());

        final Personal updatedPersonal = savePersonal(personal).getBody();
        return ResponseEntity.ok(updatedPersonal);

    }

    // Delete
    public Map<String, Boolean> deletePersonal(Long id) throws ResourceNotFoundException {
        Personal personal = getPersonalById(id).getBody();
        personalRepository.delete(personal);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}