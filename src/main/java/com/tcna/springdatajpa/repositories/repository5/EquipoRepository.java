package com.tcna.springdatajpa.repositories.repository5;

import com.tcna.springdatajpa.entitites.entity5.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
