package com.example.prueba2_spring_boot.controller;

import com.example.prueba2_spring_boot.entities.Cursos;
import com.example.prueba2_spring_boot.entities.Persona;
import com.example.prueba2_spring_boot.repository.CursosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.prueba2_spring_boot.service.CursosService;

@RestController
@RequestMapping("/tabla_personas/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursosService cursosService;

    @GetMapping
    public ResponseEntity<Page<Cursos>> findAll(Pageable pageable){
        return new ResponseEntity<>(cursosService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Cursos> findbyNombre(@PathVariable String nombre){
        return new ResponseEntity<>(cursosService.findByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cursos> create(@RequestBody Cursos cursos){
        return new ResponseEntity<>(cursosService.create(cursos), HttpStatus.CREATED);
    }

    @PutMapping("/{nombre}")
    public ResponseEntity<Cursos> update(@PathVariable String nombre, @RequestBody Cursos cursos){
        return new ResponseEntity<>(cursosService.update(nombre, cursos), HttpStatus.OK);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> deletebyName(@PathVariable String nombre){
        cursosService.deletebyName(nombre);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
