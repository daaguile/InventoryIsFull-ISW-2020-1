package com.inventoryisfull.service;

import com.inventoryisfull.repository.PabellonRepository;
import com.inventoryisfull.domain.Pabellon;
import com.inventoryisfull.dto.PabellonDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;

import org.springframework.http.ResponseEntity;
import com.inventoryisfull.exceptions.*;

@Service
public class PabellonService {

    @Autowired
    private PabellonRepository pabellonRepository;

    @Autowired
    private PabellonMapService pabellonMapService;


    // Create
    public ResponseEntity<PabellonDTO> savePabellon(Pabellon pabellon) {
        Pabellon newPabellon = pabellonRepository.save(pabellon);
        PabellonDTO pabellonDTO = pabellonMapService.mapPabellonToDTO(newPabellon);
        return ResponseEntity.ok(pabellonDTO);
    }

    // Read
    public Iterable<PabellonDTO> listPabellones() {
        return pabellonMapService.getAllPabellon();
    }

    public ResponseEntity<PabellonDTO> getPabellonDTOById(Long id) throws ResourceNotFoundException {
        Pabellon pabellon = pabellonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pabellon not found for this id :: " + id));
        PabellonDTO pabellonDTO = pabellonMapService.mapPabellonToDTO(pabellon);
        return ResponseEntity.ok(pabellonDTO);
    }

    private ResponseEntity<Pabellon> getPabellonById(Long id) throws ResourceNotFoundException {
        Pabellon pabellon = pabellonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pabellon not found for this id :: " + id));
        return ResponseEntity.ok(pabellon);
    }

    // Update
    public ResponseEntity<PabellonDTO> updatePabellon(Pabellon editPabellon, Long id) throws ResourceNotFoundException {

        Pabellon pabellon = getPabellonById(id).getBody();

        pabellon.setSala(editPabellon.getSala());
        pabellon.setDescripcion(editPabellon.getDescripcion());
        pabellon.setEstado(editPabellon.getEstado());

        return ResponseEntity.ok(savePabellon(pabellon).getBody());

    }
    
    // Delete
    public JSONObject deletePabellon(Long id) throws ResourceNotFoundException {
        Pabellon pabellon = getPabellonById(id).getBody();
        pabellonRepository.delete(pabellon);

        // Map<String, Boolean> response = new HashMap<>();
        // response.put("ok", Boolean.TRUE);
        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("ok", Boolean.TRUE);
        jsonObject.appendField("mensaje", "Pabellon eliminado");
        return jsonObject;
    }

}