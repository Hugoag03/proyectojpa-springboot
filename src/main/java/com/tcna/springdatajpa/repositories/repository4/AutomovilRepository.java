package com.tcna.springdatajpa.repositories.repository4;

import com.tcna.springdatajpa.entitites.entity4.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovilRepository extends JpaRepository<Automovil, Long> {
}
