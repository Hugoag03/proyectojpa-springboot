package com.tcna.springdatajpa.repositories.repository3;

import com.tcna.springdatajpa.entitites.entity3.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {
}
