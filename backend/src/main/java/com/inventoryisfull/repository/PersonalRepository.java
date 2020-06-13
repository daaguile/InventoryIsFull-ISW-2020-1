package com.inventoryisfull.repository;

import com.inventoryisfull.domain.Personal;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long>{
    
}