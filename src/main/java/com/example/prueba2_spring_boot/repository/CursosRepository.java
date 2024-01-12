package com.example.prueba2_spring_boot.repository;

import com.example.prueba2_spring_boot.entities.Cursos;
import com.example.prueba2_spring_boot.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

    Optional<Cursos> findByNombre(String nombre);
}
