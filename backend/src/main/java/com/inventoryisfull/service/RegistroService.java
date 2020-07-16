package com.inventoryisfull.service;

import com.inventoryisfull.domain.Pabellon;
import com.inventoryisfull.domain.Registro;
import com.inventoryisfull.dto.RegistroDTO;
import com.inventoryisfull.exceptions.ResourceNotFoundException;
import com.inventoryisfull.mapservice.RegistroMapService;
import com.inventoryisfull.repository.PabellonRepository;
import com.inventoryisfull.repository.RegistroRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Service
public class RegistroService {

    private static final String OCUPADO = "ocupado";

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private RegistroMapService registroMapService;

    @Autowired
    private PabellonRepository pabellonRepository;

    // Read
    public Iterable<RegistroDTO> listRegistros() {
        return registroMapService.getAllRegistros();
    }

    // Create
    public ResponseEntity<RegistroDTO> saveRegistro(Registro registro) throws ResourceNotFoundException {

        Long idPabellon = registro.getPabellon().getId();
        Pabellon pabellon = pabellonRepository.findById(idPabellon)
                .orElseThrow(() -> new ResourceNotFoundException("Pabellon not found for this id :: " + idPabellon));

        pabellon.setEstado(OCUPADO);
        pabellonRepository.save(pabellon);
        
        Registro newRegistro = registroRepository.save(registro);
        RegistroDTO registroDTO = registroMapService.mapRegistroToDTO(newRegistro);
        return ResponseEntity.ok(registroDTO);
    }


}