package com.example.backSitum.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.backSitum.repository.DuenoRepository;
import com.example.backSitum.model.Dueno;

import java.util.List;
import java.util.Optional;

@Service
public class DuenoService {

    private final DuenoRepository duenoRepository;

    @Autowired
    public DuenoService(DuenoRepository duenoRepository) {
        this.duenoRepository = duenoRepository;
    }

    //Crear un Dueño
    public Dueno saveDueno(Dueno dueno) {
        return duenoRepository.save(dueno);
    }

    //Buscar todos los Dueños
    public List<Dueno> getDuenos() {
        return duenoRepository.findAll();
    }  

    //Buscar Dueño por ID
    public Optional<Dueno> getDuenoById(Long id) {
        return duenoRepository.findById(id);
    }

    //Eliminar Dueño por ID
    public void deleteDueno(Long id) {
        duenoRepository.deleteById(id);
    }

    //Actualizar Dueño
    public Dueno updateDueno(Long id, Dueno dueno) {
        if (duenoRepository.existsById(id)) {
            return duenoRepository.save(dueno);
        } else {
            throw new RuntimeException("Dueno no encontrado con ID: " + id);
        }
    }
    
}
