package com.example.backSitum.repository;

import com.example.backSitum.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    
}
