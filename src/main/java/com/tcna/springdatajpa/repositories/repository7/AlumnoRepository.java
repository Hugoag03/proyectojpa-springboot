package com.tcna.springdatajpa.repositories.repository7;

import com.tcna.springdatajpa.entitites.entity7.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
