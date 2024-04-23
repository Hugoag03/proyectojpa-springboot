package com.tcna.springdatajpa.repositories.repository2;


import com.tcna.springdatajpa.entitites.entity2.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
