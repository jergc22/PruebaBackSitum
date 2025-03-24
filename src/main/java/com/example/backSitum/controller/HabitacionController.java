package com.example.backSitum.controller;

import org.springframework.web.bind.annotation.*;
import com.example.backSitum.model.Habitacion;
import com.example.backSitum.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.backSitum.errores.NoEncontrado;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/habitaciones")
@Tag(name = "Habitaciones", description = "Gestión de habitaciones")
public class HabitacionController {

    private static final Logger logger = LoggerFactory.getLogger(HabitacionController.class);

    @Autowired
    private HabitacionService habitacionService;

    @Operation(summary = "Obtener todas las habitaciones")
    @GetMapping
    public ResponseEntity<List<Habitacion>> getHabitaciones() {
        logger.info("Obteniendo todas las habitaciones");
        return new ResponseEntity<>(habitacionService.getHabitaciones(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una habitación por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Habitacion>> getHabitacionById(@PathVariable Long id) {
        logger.info("Obteniendo habitación con ID: {}", id);
        Optional<Habitacion> habitacion = habitacionService.getHabitacionById(id);
        if (habitacion.isEmpty()) {
            logger.warn("Habitación no encontrada con ID: {}", id);
            throw new NoEncontrado("Habitación no encontrada con ID: " + id);
        }
        return new ResponseEntity<>(habitacion, HttpStatus.OK);
    }

    @Operation(summary = "Guardar una nueva habitación")
    @PostMapping
    public ResponseEntity<Habitacion> saveHabitacion(@RequestBody Habitacion habitacion) {
        logger.info("Guardando nueva habitación: {}", habitacion);
        return new ResponseEntity<>(habitacionService.saveHabitacion(habitacion), HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar una habitación por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHabitacion(@PathVariable Long id) {
        logger.info("Eliminando habitación con ID: {}", id);
        Optional<Habitacion> habitacion = habitacionService.getHabitacionById(id);
        if (habitacion.isEmpty()) {
            logger.warn("Habitación no encontrada con ID: {}", id);
            throw new NoEncontrado("Habitación no encontrada con ID: " + id);
        }
        habitacionService.deleteHabitacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Actualizar una habitación")
    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> updateHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacion) {
        logger.info("Actualizando habitación con ID: {}", id);
        Optional<Habitacion> existingHabitacion = habitacionService.getHabitacionById(id);
        if (existingHabitacion.isEmpty()) {
            logger.warn("Habitación no encontrada con ID: {}", id);
            throw new NoEncontrado("Habitación no encontrada con ID: " + id);
        }
        return new ResponseEntity<>(habitacionService.updateHabitacion(id, habitacion), HttpStatus.OK);
    }
}