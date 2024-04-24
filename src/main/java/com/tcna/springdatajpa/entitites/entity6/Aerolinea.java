package com.tcna.springdatajpa.entitites.entity6;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "aerolinea", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Vuelo> vuelos = new ArrayList<>();
}
