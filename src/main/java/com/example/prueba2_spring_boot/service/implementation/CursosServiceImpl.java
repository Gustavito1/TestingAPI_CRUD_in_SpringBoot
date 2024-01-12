package com.example.prueba2_spring_boot.service.implementation;


import com.example.prueba2_spring_boot.entities.Cursos;
import com.example.prueba2_spring_boot.entities.Persona;
import com.example.prueba2_spring_boot.repository.CursosRepository;
import com.example.prueba2_spring_boot.service.CursosService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class CursosServiceImpl implements CursosService {
    private final CursosRepository cursosRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Cursos> findAll(Pageable pageable) {
        return cursosRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cursos findByNombre(String nombre) {
        return cursosRepository.findByNombre(nombre)
                .orElseThrow(() -> new EntityNotFoundException("El curso con nombre '" + nombre + "' no existe"));
    }

    @Override
    public Cursos create(Cursos cursos) {
        Optional<Cursos> cursoOptional = cursosRepository.findByNombre(cursos.getNombre());
        if(cursoOptional.isPresent()){
            throw new DuplicateKeyException("La categoría con nombre '" + cursos.getNombre() + "' ya existe");
        }
        return cursosRepository.save(cursos);
    }

    @Override
    public Cursos update(String nombre, Cursos cursos) {
        Cursos cursoUpt = this.findByNombre(nombre);
        if(!cursoUpt.getNombre().equals(cursos.getNombre())){
            Optional<Cursos> cursoOptional = cursosRepository.findByNombre(cursos.getNombre());
            if(cursoOptional.isPresent()){
                throw new DuplicateKeyException("La categoría '" + cursos.getNombre() + "' ya existe");
            }
        }
        cursoUpt.setNombre(cursos.getNombre());
        cursoUpt.setCreditos(cursos.getCreditos());
        cursoUpt.setCiclos(cursos.getCiclos());

        return cursosRepository.save(cursoUpt);
    }

    @Override
    public void deletebyName(String nombre) {
        Cursos cursos = this.findByNombre(nombre);
        cursosRepository.deleteById(cursos.getId());

    }
}
