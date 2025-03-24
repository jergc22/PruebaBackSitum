package com.example.backSitum.repository;

import com.example.backSitum.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    
}
