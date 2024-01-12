package com.example.prueba2_spring_boot.service;

import com.example.prueba2_spring_boot.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonaService {

    Page<Persona> findAll(Pageable pageable);

    Persona findByNombre(String nombre);

    Persona create(Persona persona);

    Persona update(String nombre, Persona persona);

    void deletebyName(String nombre);
}
