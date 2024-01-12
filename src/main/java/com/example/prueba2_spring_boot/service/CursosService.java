package com.example.prueba2_spring_boot.service;

import com.example.prueba2_spring_boot.entities.Cursos;
import com.example.prueba2_spring_boot.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CursosService {

    Page<Cursos> findAll(Pageable pageable);

    Cursos findByNombre(String nombre);

    Cursos create(Cursos cursos);

    Cursos update(String nombre, Cursos cursos);

    void deletebyName(String nombre);
}
