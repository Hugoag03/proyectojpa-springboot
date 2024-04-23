package com.tcna.springdatajpa.repositories.repository1;

import com.tcna.springdatajpa.entitites.entity1.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
