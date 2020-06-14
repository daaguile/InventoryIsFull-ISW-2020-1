package com.inventoryisfull.repository;

import com.inventoryisfull.domain.Pabellon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Long> {

}