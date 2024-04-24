package com.tcna.springdatajpa.repositories.repository7;

import com.tcna.springdatajpa.entitites.entity7.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
