package com.tcna.springdatajpa.entitites.entity5;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int NumeroCamiseta;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

}
