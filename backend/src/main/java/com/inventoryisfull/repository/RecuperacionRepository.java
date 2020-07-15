package com.inventoryisfull.repository;

import com.inventoryisfull.domain.Recuperacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecuperacionRepository extends CrudRepository<Recuperacion, Long> {
    
}