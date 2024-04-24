package com.tcna.springdatajpa.entitites.entity6;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;
    private int numeroVuelo;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")
    private Aerolinea aerolinea;



}
