package com.inventoryisfull.service;

import com.inventoryisfull.repository.PabellonRepository;
import com.inventoryisfull.domain.Pabellon;

import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.inventoryisfull.exceptions.*;

@Service
public class PabellonService {

    @Autowired
    private PabellonRepository pabellonRepository;


    // Create
    public ResponseEntity<Pabellon> savePabellon(Pabellon pabellon) {
        Pabellon newPabellon = pabellonRepository.save(pabellon);
        return ResponseEntity.ok(newPabellon);
    }

    // Read
    public Iterable<Pabellon> listPabellones() {
        return pabellonRepository.findAll();
    }

    public ResponseEntity<Pabellon> getPabellonById(Long id) throws ResourceNotFoundException {
        Pabellon pabellon = pabellonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pabellon not found for this id :: " + id));
        return ResponseEntity.ok(pabellon);
    }

    // Update
    public ResponseEntity<Pabellon> updatePabellon(Pabellon newPabellon, Long id) throws ResourceNotFoundException {

        Pabellon pabellon = getPabellonById(id).getBody();

        pabellon.setPiso(newPabellon.getPiso());
        pabellon.setServicio(newPabellon.getServicio());
        pabellon.setEspecialidad(newPabellon.getEspecialidad());
        pabellon.setMedicoJefeNombre(newPabellon.getMedicoJefeNombre());
        pabellon.setMedicoJefeApellido(newPabellon.getMedicoJefeApellido());

        final Pabellon updatedPabellon = savePabellon(pabellon).getBody();
        return ResponseEntity.ok(updatedPabellon);

    }
    
    // Delete
    public Map<String, Boolean> deletePabellon(Long id) throws ResourceNotFoundException {
        Pabellon pabellon = getPabellonById(id).getBody();
        pabellonRepository.delete(pabellon);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}