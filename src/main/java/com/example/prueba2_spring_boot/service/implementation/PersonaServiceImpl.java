package com.example.prueba2_spring_boot.service.implementation;


import com.example.prueba2_spring_boot.entities.Persona;
import com.example.prueba2_spring_boot.repository.PersonaRepository;
import com.example.prueba2_spring_boot.service.PersonaService;
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
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> findAll(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre)
                .orElseThrow(() -> new EntityNotFoundException("La Persona con nombre '" + nombre + "' no existe"));
    }

    @Override
    public Persona create(Persona persona) {
        Optional<Persona> personaOptional = personaRepository.findByNombre(persona.getNombre());
        if(personaOptional.isPresent()){
            throw new DuplicateKeyException("La categoría con nombre '" + persona.getNombre() + "' ya existe");
        }
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(String nombre, Persona persona) {
        Persona personaUpdt = this.findByNombre(nombre);
        if(!personaUpdt.getNombre().equals(persona.getNombre())){
            Optional<Persona> personaOptional = personaRepository.findByNombre(persona.getNombre());
            if(personaOptional.isPresent()){
                throw new DuplicateKeyException("La categoría '" + persona.getNombre() + "' ya existe");
            }
        }
        personaUpdt.setNombre(persona.getNombre());
        personaUpdt.setEdad(persona.getEdad());
        return personaRepository.save(personaUpdt);
    }

    @Override
    public void deletebyName(String nombre) {
        Persona persona = this.findByNombre(nombre);
        personaRepository.deleteById(persona.getId());

    }

}
