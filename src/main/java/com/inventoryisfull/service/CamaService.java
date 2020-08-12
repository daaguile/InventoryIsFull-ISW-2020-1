package com.inventoryisfull.service;

import com.inventoryisfull.domain.Cama;
import com.inventoryisfull.dto.CamaDTO;
import com.inventoryisfull.exceptions.ResourceNotFoundException;
import com.inventoryisfull.mapservice.CamaMapService;
import com.inventoryisfull.repository.CamaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;

@Service
public class CamaService {
    
    @Autowired
    private CamaRepository camaRepository;

    @Autowired
    private CamaMapService camaMapService;

    // Create
    public ResponseEntity<CamaDTO> saveCama(Cama cama) {
        cama.setEstado("Disponible");
        Cama newCama = camaRepository.save(cama);
        CamaDTO camaDTO = camaMapService.mapCamaToDTO(newCama);
        return ResponseEntity.ok(camaDTO);
    }

    // Read
    public Iterable<CamaDTO> listCamas() {
        return camaMapService.getAllCamas();
    }
    
    public ResponseEntity<CamaDTO> getCamaDTOById(Long id) throws ResourceNotFoundException {
        Cama cama = camaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Cama not found for this id :: " + id));
        CamaDTO camaDTO = camaMapService.mapCamaToDTO(cama);
        return ResponseEntity.ok(camaDTO);
    }

    private ResponseEntity<Cama> getCamaById(Long id) throws ResourceNotFoundException {
        Cama cama = camaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cama not found for this id :: " + id));
        return ResponseEntity.ok(cama);
    }

    // Update
    public ResponseEntity<CamaDTO> updateCama(JSONObject editCama, Long id) throws ResourceNotFoundException {
        Cama cama = getCamaById(id).getBody();
        String estado = editCama.getAsString("estado");
        cama.setEstado(estado);
        return ResponseEntity.ok(camaMapService.mapCamaToDTO(camaRepository.save(cama)));
    }

    // Delete
    public JSONObject deleteCama(Long id) throws ResourceNotFoundException {
        Cama cama = getCamaById(id).getBody();
        camaRepository.delete(cama);

        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("ok", Boolean.TRUE);
        jsonObject.appendField("mensaje", "Cama eliminada");
        return jsonObject;
    }


}