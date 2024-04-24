package com.tcna.springdatajpa.entitites.entity2;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

}
