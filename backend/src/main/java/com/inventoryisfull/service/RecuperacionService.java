package com.inventoryisfull.service;

import com.inventoryisfull.repository.CamaRepository;
import com.inventoryisfull.repository.RecuperacionRepository;

import com.inventoryisfull.domain.Cama;
import com.inventoryisfull.domain.Recuperacion;
import com.inventoryisfull.dto.RecuperacionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.springframework.http.ResponseEntity;
import com.inventoryisfull.exceptions.*;
import com.inventoryisfull.mapservice.RecuperacionMapService;

@Service
public class RecuperacionService {

    @Autowired
    private RecuperacionRepository recuperacionRepository;

    @Autowired
    private RecuperacionMapService recuperacionMapService;

    @Autowired
    private CamaRepository camaRepository;

    // Create
    public ResponseEntity<RecuperacionDTO> saveRecuperacion(Recuperacion recuperacion) {
        Recuperacion newRecuperacion = recuperacionRepository.save(recuperacion);
        RecuperacionDTO recuperacionDTO = recuperacionMapService.mapRecuperacionToDTO(newRecuperacion);
        recuperacionDTO.setCamas(new JSONArray());
        return ResponseEntity.ok(recuperacionDTO);
    }

    // Read
    public Iterable<RecuperacionDTO> listRecuperacion() {
        Iterable<RecuperacionDTO> salasDTO = recuperacionMapService.getAllRecuperacion();

        for (RecuperacionDTO salaDTO : salasDTO) {
            JSONArray camas = getCamas(salaDTO.getId());
            salaDTO.setCamas(camas);;
        }
        return salasDTO;
    }

    public ResponseEntity<RecuperacionDTO> getRecuperacionDTOById(Long id) throws ResourceNotFoundException {
        Recuperacion recuperacion = recuperacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Sala de Recuperacion not found for this id :: " + id));
        RecuperacionDTO recuperacionDTO = recuperacionMapService.mapRecuperacionToDTO(recuperacion);

        Long idSala = recuperacion.getId();
        JSONArray idCamas = getCamas(idSala);
        recuperacionDTO.setCamas(idCamas);
        return ResponseEntity.ok(recuperacionDTO);
    }

    public ResponseEntity<RecuperacionDTO> camaToRecuperacion(JSONObject camaRecuperacion)
            throws ResourceNotFoundException {
        Long idSala = camaRecuperacion.getAsNumber("idSala").longValue();
        Long idCama = camaRecuperacion.getAsNumber("idCama").longValue();

        Recuperacion recuperacion = recuperacionRepository.findById(idSala).orElseThrow(
                () -> new ResourceNotFoundException("Sala de Recuperacion not found for this id :: " + idSala));

        Cama cama = camaRepository.findById(idCama)
                .orElseThrow(() -> new ResourceNotFoundException("Cama not found for this id :: " + idCama));

        cama.setRecuperacion(recuperacion);
        camaRepository.save(cama);

        RecuperacionDTO recuperacionDTO = recuperacionMapService.mapRecuperacionToDTO(recuperacion);
        JSONArray idCamas = getCamas(idSala);
        recuperacionDTO.setCamas(idCamas);
        return ResponseEntity.ok(recuperacionDTO);
    }

    public ResponseEntity<RecuperacionDTO> camaOutRecuperacion(JSONObject camaRecuperacion)
            throws ResourceNotFoundException {
        Long idSala = camaRecuperacion.getAsNumber("idSala").longValue();
        Long idCama = camaRecuperacion.getAsNumber("idCama").longValue();

        Recuperacion recuperacion = recuperacionRepository.findById(idSala).orElseThrow(
                () -> new ResourceNotFoundException("Sala de Recuperacion not found for this id :: " + idSala));

        Cama cama = camaRepository.findById(idCama)
                .orElseThrow(() -> new ResourceNotFoundException("Cama not found for this id :: " + idCama));

        cama.setRecuperacion(null);
        camaRepository.save(cama);

        RecuperacionDTO recuperacionDTO = recuperacionMapService.mapRecuperacionToDTO(recuperacion);
        JSONArray idCamas = getCamas(idSala);
        recuperacionDTO.setCamas(idCamas);
        return ResponseEntity.ok(recuperacionDTO);
    }
    

    private JSONArray getCamas(Long id) {
        
        JSONArray idCamas = new JSONArray();
        Iterable<Cama> camas = camaRepository.findAll();
        for (Cama cama : camas) {
            if (cama.getRecuperacion() != null && cama.getRecuperacion().getId().equals(id))  {
                idCamas.add(cama.getId());
            }
        }
        return idCamas;
    }
}