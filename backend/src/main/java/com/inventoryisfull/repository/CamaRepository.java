package com.inventoryisfull.repository;

import com.inventoryisfull.domain.Cama;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamaRepository extends CrudRepository<Cama, Long> {
    
}