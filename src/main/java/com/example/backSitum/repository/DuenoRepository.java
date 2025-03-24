package com.example.backSitum.repository;

import com.example.backSitum.model.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DuenoRepository extends JpaRepository<Dueno, Long> {
    
}
