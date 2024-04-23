package com.tcna.springdatajpa.repositories.repository2;


import com.tcna.springdatajpa.entitites.entity2.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
