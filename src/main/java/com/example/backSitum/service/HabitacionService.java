package com.example.backSitum.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.backSitum.repository.HabitacionRepository;
import com.example.backSitum.model.Habitacion;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
    
    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    //Crear una Habitacion
    public Habitacion saveHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    //Buscar todas las Habitaciones
    public List<Habitacion> getHabitaciones() {
        return habitacionRepository.findAll();
    }

    //Buscar Habitacion por ID
    public Optional<Habitacion> getHabitacionById(Long id) {
        return habitacionRepository.findById(id);
    }

    //Eliminar Habitacion por ID
    public void deleteHabitacion(Long id) {
        habitacionRepository.deleteById(id);
    }

    //Actualizar Habitacion
    public Habitacion updateHabitacion(Long id, Habitacion habitacion) {
        if (habitacionRepository.existsById(id)) {
            return habitacionRepository.save(habitacion);
        } else {
            throw new RuntimeException("Habitacion no encontrada con ID: " + id);
        }
    }
}
