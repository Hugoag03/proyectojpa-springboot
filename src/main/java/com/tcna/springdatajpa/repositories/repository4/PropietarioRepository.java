package com.tcna.springdatajpa.repositories.repository4;

import com.tcna.springdatajpa.entitites.entity4.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}
