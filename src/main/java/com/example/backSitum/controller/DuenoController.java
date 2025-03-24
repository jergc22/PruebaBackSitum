package com.example.backSitum.controller;

import org.springframework.web.bind.annotation.*;

import com.example.backSitum.errores.NoEncontrado;
import com.example.backSitum.model.Dueno;
import com.example.backSitum.service.DuenoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/duenos")
public class DuenoController {
    
    private final DuenoService duenoService;

    @Autowired
    public DuenoController(DuenoService duenoService) {
        this.duenoService = duenoService;
    }

    //Crear dueño
    @PostMapping
    public ResponseEntity<Dueno> saveDueno(@RequestBody Dueno dueno) {
        return new ResponseEntity<>(duenoService.saveDueno(dueno), HttpStatus.CREATED);
    }

    //Buscar todos los dueños
    @GetMapping
    public ResponseEntity<List<Dueno>> getDuenos() {
        return new ResponseEntity<>(duenoService.getDuenos(), HttpStatus.OK);
    }

    //Buscar dueño por ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Dueno>> getDuenoById(@PathVariable Long id) {
        Optional<Dueno> dueno = duenoService.getDuenoById(id);
        if (dueno.isEmpty()) {
            throw new NoEncontrado("Dueño no encontrado con ID: " + id);
        }
        return new ResponseEntity<>(dueno, HttpStatus.OK);
    }

    //Eliminar dueño por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDueno(@PathVariable Long id) {
        Optional<Dueno> dueno = duenoService.getDuenoById(id);
        if (dueno.isEmpty()) {
            throw new NoEncontrado("Dueño no encontrado con ID: " + id);
        }
        duenoService.deleteDueno(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Actualizar dueño
    @PutMapping("/{id}")
    public ResponseEntity<Dueno> updateDueno(@PathVariable Long id, @RequestBody Dueno dueno) {
        Optional<Dueno> existingDueno = duenoService.getDuenoById(id);
        if (existingDueno.isEmpty()) {
            throw new NoEncontrado("Dueño no encontrado con ID: " + id);
        }
        return new ResponseEntity<>(duenoService.updateDueno(id, dueno), HttpStatus.OK);
    }
}