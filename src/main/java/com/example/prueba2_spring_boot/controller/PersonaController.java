package com.example.prueba2_spring_boot.controller;

import com.example.prueba2_spring_boot.entities.Persona;
import com.example.prueba2_spring_boot.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tabla_personas/api/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping
    public ResponseEntity<Page<Persona>> findAll(Pageable pageable){
        return new ResponseEntity<>(personaService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Persona> findbyNombre(@PathVariable String nombre){
        return new ResponseEntity<>(personaService.findByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Persona> create(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.create(persona), HttpStatus.CREATED);
    }

    @PutMapping("/{nombre}")
    public ResponseEntity<Persona> update(@PathVariable String nombre, @RequestBody Persona persona){
        return new ResponseEntity<>(personaService.update(nombre, persona), HttpStatus.OK);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> deletebyName(@PathVariable String nombre){
        personaService.deletebyName(nombre);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
