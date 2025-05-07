package com.examen.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table(name = "barcos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBarco;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private int capacidad;

}
