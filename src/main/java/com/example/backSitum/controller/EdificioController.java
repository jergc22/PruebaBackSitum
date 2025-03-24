package com.example.backSitum.controller;

import org.springframework.web.bind.annotation.*;
import com.example.backSitum.model.Edificio;
import com.example.backSitum.service.EdificioService;
import com.example.backSitum.errores.NoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/edificios")
public class EdificioController {
    
    private final EdificioService edificioService;

    @Autowired
    public EdificioController(EdificioService edificioService) {
        this.edificioService = edificioService;
    }

    //Crear edificio
    @PostMapping
    public ResponseEntity<Edificio> saveEdificio(@RequestBody Edificio edificio) {
        return new ResponseEntity<>(edificioService.saveEdificio(edificio), HttpStatus.CREATED);
    }

    //Buscar todos los edificios
    @GetMapping
    public ResponseEntity<List<Edificio>> getEdificios() {
        return new ResponseEntity<>(edificioService.getEdificios(), HttpStatus.OK);
    }

    //Buscar edificio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Edificio>> getEdificioById(@PathVariable Long id) {
        Optional<Edificio> edificio = edificioService.getEdificioById(id);
        if (edificio.isEmpty()) {
            throw new NoEncontrado("Edificio no encontrado con ID: " + id);
        }
        return new ResponseEntity<>(edificio, HttpStatus.OK);
    }

    //Eliminar edificio por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEdificio(@PathVariable Long id) {
        Optional<Edificio> edificio = edificioService.getEdificioById(id);
        if (edificio.isEmpty()) {
            throw new NoEncontrado("Edificio no encontrado con ID: " + id);
        }
        edificioService.deleteEdificio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Actualizar edificio
    @PutMapping("/{id}")
    public ResponseEntity<Edificio> updateEdificio(@PathVariable Long id, @RequestBody Edificio edificio) {
        Optional<Edificio> existingEdificio = edificioService.getEdificioById(id);
        if (existingEdificio.isEmpty()) {
            throw new NoEncontrado("Edificio no encontrado con ID: " + id);
        }
        return new ResponseEntity<>(edificioService.updateEdificio(id, edificio), HttpStatus.OK);
    }
}