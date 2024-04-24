package com.tcna.springdatajpa.repositories.repository5;

import com.tcna.springdatajpa.entitites.entity5.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
