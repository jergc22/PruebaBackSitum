package com.example.backSitum.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired; 
import com.example.backSitum.repository.EdificioRepository;
import com.example.backSitum.model.Edificio;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    //Crear un Edificio
    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    //Buscar todos los Edificios
    public List<Edificio> getEdificios() {
        return edificioRepository.findAll();
    }  

    //Buscar Edificio por ID
    public Optional<Edificio> getEdificioById(Long id) {
        return edificioRepository.findById(id);
    }

    //Eliminar Edificio por ID
    public void deleteEdificio(Long id) {
        edificioRepository.deleteById(id);
    }

    //Actualizar Edificio
    public Edificio updateEdificio(Long id, Edificio edificio) {
        if (edificioRepository.existsById(id)) {
            return edificioRepository.save(edificio);
        } else {
            throw new RuntimeException("Edificio no encontrado con ID: " + id);
        }
    }
    
}

