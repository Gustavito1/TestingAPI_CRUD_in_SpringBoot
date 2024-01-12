package com.example.prueba2_spring_boot.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_persona")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int edad;
}
