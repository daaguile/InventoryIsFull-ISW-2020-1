package com.inventoryisfull.repository;

import com.inventoryisfull.domain.Registro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

}